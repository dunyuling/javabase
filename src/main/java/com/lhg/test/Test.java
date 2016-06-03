package com.lhg.test;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.IntBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liux on 10/7/15.
 */
public class Test {

    static volatile int count = 0;
    static volatile Timer timer = new Timer();
    static volatile  boolean c = false;

    public static void main(String [] args) throws InterruptedException {
//        InetAddress netAddress = getInetAddress();
//        System.out.println("host ip:" + getHostIp(netAddress));
//        System.out.println("host name:" + getHostName(netAddress));
//        Properties properties = System.getProperties();
//        Set<String> set = properties.stringPropertyNames(); //获取java虚拟机和系统的信息。
//        for(String name : set){
//            System.out.println(name + ":" + properties.getProperty(name));
//        }

//        String host = "singerdream.com";
//        try {
//            System.out.println(InetAddress.getAllByName(host)[0].getHostAddress());
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        Test test = new Test();
//        test.schedule(timer);
//        /*try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }*/
//
//        while(!c) {
//            Thread.sleep(100);
//
//        }
//        Timer timer2 = new Timer();
//        test.schedule(timer2);

//        System.out.println(new Date());
        /*long[] arr = new long[] {1,2,3};
        List<Long> l1 = Arrays.asList(1l,2l,3l);
        List<long[]> list =  Arrays.asList(arr);
        System.out.println(list);*/


//        List<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        l1.add(2);
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(2);
//        l2.add(3);
        /*l2.removeAll(l1);
        System.out.println(l2);
        l1.removeAll(l2);
        System.out.println(l1);*/


        /*ArrayList<String> a = new ArrayList<>();
        a.add("abc");
        a.add("def");
        a.add("ghi");

        ArrayList<String> b = new ArrayList<>();
        b.add("def");
        b.add("ghi");
        b.add("jkl");


        b.removeAll(a);
        System.out.println(b);*/
//        test1(l1,l2,l2);


//        int a = 9;
//        int b = 11;
//        System.out.println((int)((float)9/11 * 100));

//        int subLength = 10;
//        int totalLength = 100;
//        System.out.println("bytes="+ (subLength + 1) + "-" + totalLength);
//        String title = "tutorianname  sex chapterperiod chaptername lessonperiod lessonname type";
//        String titleArr[] = title.split("\\s+");
//        System.out.println(titleArr[0]);
//        System.out.println(titleArr[2] + "/" + titleArr[5]);
//        System.out.println(titleArr[6].substring(0,1));

//        int size = 6594910;
//        System.out.println();
//
//
//
//
//        float result = (float)size/(1000*1000);
////        result =(float)(Math.round(result*100)/100f);
////        System.out.println(result);
//
//
//        DecimalFormat decimalFormat=new DecimalFormat(".00");
//        String d = decimalFormat.format(result);
//        System.out.println("d: " + d);
//
//        float   a   =   123.2334f;
//        float   b   =   (float)(Math.round(a*100))/100;
//        System.out.println("b: " + b);
//
//        System.exit(0);

//        System.out.println("main: " + Thread.currentThread().hashCode());
//        DirectorExecutor executor = new DirectorExecutor();
//        executor.execute(runnable);
//
//
//        ((ExecutorService)Executors.newSingleThreadExecutor()).execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("single: " + Thread.currentThread().hashCode());
//            }
//        });
//
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("single: " + Thread.currentThread().hashCode());
//            }
//        });


        

//        System.out.println(new Date(1464155801512l));
//
//
//        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(2);
//        queue.add(1);
//        queue.add(2);
//        queue.forEach(System.out::println);
//        boolean result = queue.remove(2);
//        System.out.println("--- \t" +  result);
//        queue.forEach(System.out::println);
//
        System.exit(0);
    }

    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("executor2: " + Thread.currentThread().hashCode());
        }
    };

    static class DirectorExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
            command.run();
            System.out.println("executor1: " + Thread.currentThread().hashCode());
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(new Date());
        }
    }

    private static void test1(List<Integer> l1 ,List<Integer> l2,List<Integer> l3) {
        l2.removeAll(l1);
        System.out.println(l2);
        l1.removeAll(l3);
        System.out.println(l1);
    }

    private synchronized void schedule(Timer timer) {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(timer.hashCode() + "\t " + hashCode());
                while(count < 10) {
                    System.out.println(count);
                    count++;
                }
                if(count>=10) {
                    count = 0;
                    c=true;
                    timer.cancel();
                    System.out.println("timer is canceled");
                }
            }
        },50,100);
    }

    public static InetAddress getInetAddress(){

        try{
            return InetAddress.getLocalHost();
        }catch(UnknownHostException e){
            System.out.println("unknown host!");
        }
        return null;

    }

    public static String getHostIp(InetAddress netAddress){
        if(null == netAddress){
            return null;
        }
        String ip = netAddress.getHostAddress(); //get the ip address
        return ip;
    }

    public static String getHostName(InetAddress netAddress){
        if(null == netAddress){
            return null;
        }
        String name = netAddress.getHostName(); //get the host address
        return name;
    }



    private void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                test2();
            }
        }).start();
    }

    private void test2() {
        System.out.println(this instanceof Test);
    }

}
