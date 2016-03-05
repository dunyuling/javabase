package com.lhg.test.thread.notifyTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by liux on 16-1-28.
 */
public class BusyWaiting1 {
    public static void main(String[] args) {
        Monitor1 monitor = new Monitor1();
        MyObject1 o = new MyObject1(monitor);
        new Thread(o).start();
        new Thread(monitor).start();
    }
}

class MyObject1 implements Runnable {
    private Monitor1 monitor;

    public MyObject1(Monitor1 monitor) {
        this.monitor = monitor;
    }

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("i'm going.");
            monitor.gotMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Monitor1 implements Runnable {
    private volatile boolean go = false;

    public synchronized void gotMessage() throws InterruptedException {
        go = true;
        notify();
    }

    public synchronized void watching() throws InterruptedException {
        while (!go)
            wait();
        System.out.println("He has gone.");
    }

    public void run() {
        try {
            watching();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
