package com.lhg.test;

import java.util.Calendar;

/**
 * Created by liuhuiguang on 15-10-19.
 */
public class StringMerger {
    public static String merge(String[] strings, String separator, boolean isSepAtTail) {
        if (strings == null) {
            return null;
        }
        if (separator == null) {
            separator = "";
        }

        String mergedString = new String();
        for (int i = 0; i < strings.length - 1; i++) {
            mergedString += (strings[i] + separator);
        }

        mergedString += strings[strings.length - 1];
        if (isSepAtTail) {
            mergedString += separator;
        }

        return mergedString;
    }

    public static String bufferMerge(String[] strings, String separator, boolean isSepAtTail) {
        if (strings == null) {
            return null;
        }
        if (separator == null) {
            separator = "";
        }

        StringBuffer mergeSb = new StringBuffer();
        for (int i = 0; i < strings.length - 1; i++) {
            mergeSb.append(strings[i]).append(separator);
        }

        mergeSb.append(strings[strings.length - 1]);
        if (isSepAtTail) {
            mergeSb.append(separator);
        }

        return mergeSb.toString();
    }

    public static void main(String[] args) {
        // call the two methods to initialize the class and methods.
        System.out.println(StringMerger.merge(new String[] {"a", "kk", "ef"}, " ^_^ ", false));
        System.out.println(StringMerger.bufferMerge(new String[] {"a", "kk", "ef"}, " ^_^ ", false));

        final int n = 10000;
        final String sep = System.getProperty("line.separator");

        // create an array of String for merging.
        String[] forMerge = new String[n];
        for (int i = 0; i < n; i++) {
            forMerge[i] = Integer.toBinaryString(i);
        }

        // declare two variables to store start time and end time.
        long startTime = 0;
        long endTime = 0;

        // run the test code 5 times.
        for (int i = 0; i < 5; i++) {
            System.out.println("===");

            // get current time as start time.
            startTime = Calendar.getInstance().getTimeInMillis();
            // merge string by using String.
            StringMerger.bufferMerge(forMerge, sep, false);
            // get current time as end time.
            endTime = Calendar.getInstance().getTimeInMillis();
            // print out the result.
            System.out.println("merge by StringBuffer start: " + startTime);
            System.out.println("merge time: " + (endTime - startTime));
            System.out.println("merge by StringBuffer end: " + endTime);

            // get current time as start time.
            startTime = Calendar.getInstance().getTimeInMillis();
            // merge string by using StringBuffer.
            StringMerger.merge(forMerge, sep, false);
            // get current time as end time.
            endTime = Calendar.getInstance().getTimeInMillis();
            // print out the result.
            System.out.println("merge by String start: " + startTime);
            System.out.println("merge time: " + (endTime - startTime));
            System.out.println("merge by String end: " + endTime);
        }
    }
}
