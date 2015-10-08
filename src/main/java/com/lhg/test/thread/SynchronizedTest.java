package com.lhg.test.thread;

/**
 * Created by liuhuiguang on 15-9-10.
 */
public class SynchronizedTest {
    public static void main(String[] args) {
//        TxtThread tt = new TxtThread();
//        new Thread(tt).start();
//        new Thread(tt).start();
//        new Thread(tt).start();
//        new Thread(tt).start();

//        float f = (2/100f) * 360;
        float f = 2 * 360 / 100f;
        System.out.println(f);
    }
}


class TxtThread implements Runnable {
    int num = 100;
    final String str = new String();

    public void run() {
        synchronized ((Object)num) {
            while (num > 0) {

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.getMessage();
                }
                System.out.println(Thread.currentThread().getName()
                        + "\tthis is " + num--);
            }
        }
    }
}