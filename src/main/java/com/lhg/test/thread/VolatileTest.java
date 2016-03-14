package com.lhg.test.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuhg on 16-3-4.
 */
public class VolatileTest {

    private String name = "ab";

    private int age = 12;

    private String getName() {
        return name;
    }

    private int a = 0;

    private AtomicInteger aa = new AtomicInteger(0);

    private final Object object = new Object();

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        VolatileTest ab = new VolatileTest();
        ab.test();
        ab.test1();

    }

    private void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object) {
                        a++;
                    }
////                    aa.getAndSet(a++);
//                    a++;
//                    synchronized (object) {
                        System.out.println("111: " +  a + "\t" + formatTime(System.currentTimeMillis()));
//                    }
                }
            }
        }).start();
    }

    private void test1() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    synchronized (object) {
                        System.out.println("222: " + a + "\t" + formatTime(System.currentTimeMillis()));
//                    }
                }
            }
        });
    }

    private String formatTime(long millSeconds) {
        synchronized (object) {
            DateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss SSS");
            return simpleDateFormat.format(new Date(millSeconds));
        }
    }
}