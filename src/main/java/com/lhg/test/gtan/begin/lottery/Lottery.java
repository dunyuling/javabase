package com.lhg.test.gtan.begin.lottery;
import java.util.*;
import java.lang.*;
import java.io.IOException;

public class Lottery {
    public static void main(String args[]) {
	lottery(createAllRandom());
    }

    public static void lottery(List<String> allRandom) {
        Set<Integer> usedNum = new HashSet<Integer>();      

        int i=3,checkNum = 0,randomNum = 0,count = 50;
        String strCode = null;
        System.out.println("请抽奖，每次共有三次机会.回车确认.");
        while(i>0) {
            try{
                checkNum = System.in.read();
            }catch(IOException e) {
                e.printStackTrace();
            }

            if(checkNum == 10) {
		boolean found = false;
		do { 
	            randomNum = (int)(Math.random()*count);
		    if(!usedNum.contains(randomNum)) {
			strCode = allRandom.get(randomNum);
			usedNum.add(randomNum);
			i--;
			found = true;
		    }
		} while(!found);     
            }   

            System.out.println("您抽到的号码为："+strCode);
            if(i>0) {
                System.out.println("您还有"+i+"次机会");
            } else if (i==0) {
                System.out.println("感谢您对本系统的使用，欢迎下次继续使用！");
            }       
        }
    }

    public static List<String> createAllRandom() {
        Random rdm = new Random();
        List<String> allRandom = new LinkedList<>();
	/*下面的定义没有实际应用只为提升效能*/
        Set<String> generated = new HashSet<>();
        int i = 50;
        while(i>0) {
            String str = createRandom();
            if(!generated.contains(str)) {
                str = createRandom();
                generated.add(str);
                allRandom.add(str);
                i --;
            }
        }
	return allRandom;
    }    	

    public static String createRandom() {
        StringBuffer buffer = new StringBuffer();
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int i = 0,j = 0,z = 0;
        Set<Integer> used = new HashSet<>();
      	
	int count = 62;
	for(i=0;i<4;i++) {
            boolean found = false;
	    while(!found) {
		z = (int)(Math.random()*count);
  		if(!used.contains(z)) {
                    buffer.append(str.charAt(z));
		    used.add(z);
		    found = true;
		}
            } 
	}
	return new String(buffer);
    }
}
