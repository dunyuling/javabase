package com.lhg.test.threadpool;

import java.util.Date;

/**
 * Created by liuhg on 16-3-4.
 */
public class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public MyThread() {

    }

    @Override
    public void run() {
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }*/
//        System.out.println(name + "正在进行。。。。。" + new Date(System.currentTimeMillis()));
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
    }
}
