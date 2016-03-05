package com.lhg.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 * Created by liux on 10/7/15.
 */
public class Test {
    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(getLastMonthBegin());
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1;
//        System.out.println("year: " + year + "\t month: " + month);
//        System.out.println(getLastMonthBegin());
  /*      int year = getCurYear();
        int month = getCurMonth();
        System.out.println(getMonthBegin(year,month));
        System.out.println(getMonthEnd(year,month));
        YearMonth yearMonth = getLastMonth();
        year = yearMonth.getY();
        month = yearMonth.getM();
        System.out.println("===========");
        System.out.println(getMonthBegin(year,month));
        System.out.println(getMonthEnd(year, month));*/

//        System.out.println(getMonthBegin(2015, 10) + "\t " + getMonthEnd(2015,10));

//        Date date = formatDate("2015-10-28  11:22:33.000");
//        System.out.println(date.toString());
//        System.out.println(MediaType.audio.ordinal());
        /*String s = "√";
        String s1 = "√";
        System.out.println(s == s1);*/
        System.out.println((int) "　".charAt(0));
    }

    public static Date formatDate(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        if (!time.isEmpty()) {
            try {
                date = format.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public static YearMonth getLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getLastMonthBegin());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        return new YearMonth(year,month);
    }

    public static int getCurYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static int getCurMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1 ;
    }

    public static Date getMonthBegin(int year,int month) {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.YEAR, year);
        cale.set(Calendar.MONTH,month - 1);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.HOUR_OF_DAY,0);
        cale.set(Calendar.MINUTE,0);
        cale.set(Calendar.SECOND,0);
        return cale.getTime();
    }

    public static Date getMonthEnd(int year, int month) {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.YEAR,year);
        cale.set(Calendar.MONTH,month);
        cale.set(Calendar.DAY_OF_MONTH,0);
        cale.set(Calendar.HOUR_OF_DAY,23);
        cale.set(Calendar.MINUTE,59);
        cale.set(Calendar.SECOND,59);
        return cale.getTime();
    }

    public static Date getLastMonthBegin() {
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, -1);
        cale.set(Calendar.DAY_OF_MONTH,1);
        cale.set(Calendar.HOUR_OF_DAY,0);
        cale.set(Calendar.MINUTE,0);
        cale.set(Calendar.SECOND,0);
        return cale.getTime();
    }

    public static Date getLastMonthEnd() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH,0);
        cale.set(Calendar.HOUR_OF_DAY,23);
        cale.set(Calendar.MINUTE,59);
        cale.set(Calendar.SECOND,59);
        return cale.getTime();
    }

}
