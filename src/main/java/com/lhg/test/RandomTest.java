package com.lhg.test;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.ObjectInputStream;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by liuhuiguang on 15-10-15.
 */
public class RandomTest {

    private static String base ;
    static {
        StringBuffer buffer = new StringBuffer();
        for(int i = 48;i<58;i++) {
            buffer.append((char)i);
        }
//        for(int i = 65;i<91;i++) {
//            buffer.append((char)i);
//        }
//        for(int i = 97;i<123;i++) {
//            buffer.append((char)i);
//        }
        base = new String(buffer);
    }

    public String generateRandomString(){

        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<8; i++){
            int number = getRandomNumber();
            char ch = base.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    /**
     * This method generates random numbers
     * @return int
     */
    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(base.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }


    public static void main(String[] args) {
//        long result = (long)(Math.random() * (100000000));
//        Random random = new Random();



//        System.out.println(result);

//        String s = Long.toHexString(System.currentTimeMillis());
//        System.out.println(s);

//        final RandomTest randomTest = new RandomTest();
//        randomTest.testHashCode();
//        int count = 0;
//        while(count < 10) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    randomTest.testHashCode();
//                }
//            }).start();
//            count++;
//        }
//
//        int a; int b;
//        randomTest.test1(a = 1, b = 2);
//        System.out.println("a: " + a + "\t b: " + b);


//        try {
//            RandomTest randomTest = new RandomTest().getClass().newInstance();
//            try {
//                RandomTest randomTest1 = (RandomTest) new RandomTest().clone();
//            } catch (CloneNotSupportedException e) {
//                e.printStackTrace();
//            }
//
//
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

//        System.out.println();
//        System.out.println(random.nextGaussian());
//        System.out.println(base);
//        System.out.println(new RandomTest().generateRandomString());
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH,0);
        cale.set(Calendar.HOUR_OF_DAY,23);
        cale.set(Calendar.MINUTE,59);
        cale.set(Calendar.SECOND,59);
//        lastDay = format.format(cale.getTime());
        System.out.println( cale.getTime());
    }

    public void testHashCode() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + " \t " + threadLocalRandom.hashCode());
    }

    public void testHashCode1() {

    }


    private void test1(int a, int b) {

    }
}
