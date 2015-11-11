package com.lhg.test.gtan.begin.guess;

import java.lang.Math;
import java.util.Scanner;

public class Guess {
    public static void main(String args[]) {
        int  rdm = (int)(Math.random()*100);
        // System.out.println(rdm);	
        //System.out.println(i);
	int count = 0;
	boolean flag = false;
 	/*
        while(true) {
	    System.out.println("请输入一个0到100之间的整数：");
            Scanner s = new Scanner(System.in);
            int i = s.nextInt();
            while(true) {
		if(i>rdm) {
                    System.out.println("您输入的整数太大");
                    count++;
		    break;
                } else if(i<rdm) {
                    System.out.println("您输入的整数太小");
                    count++;
                    break;
                } else {
                     count++;
                     System.out.println("输入正确，您一共猜了"+count+"次");
		     flag = true;
                     break;
                }
	    }
	    if(flag) 
		break;
        }
        */
	
	do {
	    System.out.println("请输入一个0到100之间的整数：");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();   
	    if(i>rdm) {
                System.out.println("您输入的整数太大");
                count++;
            } else if(i<rdm) {
                System.out.println("您输入的整数太小");
                count++;
            } else {
                count++;
                System.out.println("输入正确，您一共猜了"+count+"次");
                flag = true;
           }
        }while(!flag);
                 
 
    }
}
