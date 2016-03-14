package com.lhg.test.threadpool;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by liuhg on 16-3-4.
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().hashCode());
            }
        },0,1000);
    }
}
