package com.lhg.test.thread;

import java.io.*;
import java.util.Date;

public class HandleThreadException {
    public static void main(String[] args) throws InterruptedException {

        Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread th, Throwable ex) {
                /*System.out.println("Uncaught exception: ");
                for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
                    System.out.println(stackTraceElement.getClassName() + " \t " + stackTraceElement.getMethodName() + "\t " + stackTraceElement.getLineNumber()) ;
                }*/
//                print(ex);
                print(getStackTrace(ex));

            }
        };
        Thread t = new Thread() {
            public void run() {
                System.out.println("Sleeping ...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted.");
                }
                System.out.println("Throwing exception ...");
                throw new RuntimeException("aa");
            }
        };
        t.setUncaughtExceptionHandler(h);
        t.start();

        /*File file = new File("test.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write("aa".getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();

            fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write("bb".getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    private static void print(Throwable throwable) {
        File file = new File("test.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
                String message = stackTraceElement.getClassName() + " \t " + stackTraceElement.getMethodName() + "\t " + stackTraceElement.getLineNumber();
                fileOutputStream.write(message.getBytes());
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(String message) {
        File file = new File("test.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file ,true);
            fileOutputStream.write(message.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        sw.append(new Date().toString());
        sw.append(" ");
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}
