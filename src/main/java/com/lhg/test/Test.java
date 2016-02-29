package com.lhg.test;

import com.sun.deploy.util.StringUtils;

import javax.print.DocFlavor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liux on 10/7/15.
 */
public class Test {
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
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

        /*String[] arr = new String[3];
        System.out.println(arr[2]);*/


        /*new Thread(new Runnable() {
            @Override
            public void run() {

                while (count < 10) {
                    System.out.println(count + "\t" + new Date());
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }


                if(count==10) {
                    try {
                        throw new InterruptedException("count is ten");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();*/


        /*LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//        Queue<Integer> queue = new ArrayBlockingQueue<>(15);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count<arr.length) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        queue.add(arr[count]);
                    } catch (IllegalStateException e) {
//                        e.printStackTrace();
                        int pollVal = queue.poll();
                        System.out.println(pollVal + " ------------" + arr[count]);
                        queue.add(arr[count]);
                    }
                    count++;

                    for (int i : queue) {
                        System.out.print(i + "\t");
                    }
                    System.out.println();
                }

                if (count == 15) {
//                    return;
                }
                System.out.println("---");
            }
        }).start();
*/
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i : arr) {
                    try {
                        queue.put(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                Integer[] queueArray = new Integer[15];
                queue.toArray(queueArray);
                for (int i : queueArray) {
                    System.out.println(i);
                }
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/


//        System.out.println(Math.ceil(2.3));
        //720&415
//        String url = "http://qna.singerdream.com/upload/Pierce/Image/2016_JANUARY/720&415_19_1806333019070858495606190.jpg";
//        String name = url.substring(url.lastIndexOf("/") + 1,url.length());
////        boolean match = name.matches("/^*$/");
//        boolean match = Pattern.matches("^.*\\\\/\\d&\\d.*$",url);
//        String pattern = "^.*\\d&\\d.*$";
//        match = url.matches(pattern);
//
//        String[] arr =Pattern.compile(pattern).split(url);
//        System.out.println(arr);
//
//
//        url = url.replaceFirst(pattern,url);
//        System.out.println(url + "\t ======");
//
//
//
//        System.out.println(match);
//        String wh = name.substring(0,name.indexOf("_"));
//        int w = Integer.parseInt( wh.split("&")[0]);
//        int h = Integer.parseInt( wh.split("&")[1]);
//        System.out.println(wh + "\t" + w + "\t" + h);
//
//        System.out.println(Math.ceil(0));



        /*new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(currItem < 3 && up) {
                        currItem++;
                    } else if(currItem == 3) {
                        up = false;
                        currItem--;
                    } else if(currItem < 4 && currItem >= 0){
                        currItem--;
                        if(currItem == 0) {
                            up = true;
                        }
                    }
                    System.out.println(currItem);
                }


            }
        }).start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread: " + TLT.get() + " \t " + TLT.class.hashCode());
            }
        }).start();
        System.out.println("main: " + TLT.get() + " \t " + TLT.class.hashCode());


    }

    private static int currItem = 0;
    private static boolean up = true;

    private void formatTime() {

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
