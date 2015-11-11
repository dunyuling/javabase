package com.lhg.test.gtan.begin.socket;

import java.io.*;

public class Problem {
    public static void main(String args[]) {
	try {
	    boolean endTalk = false;
	    int i = 0;
	    String str = "";
	    do {
		i = System.in.read();
		if(i!=-1 && i!=10) {
		    str+=(char)i;
		} else if(i==10) {
		    System.out.println(str);
		    if(str.trim().equals("bye")) {
		        endTalk = true;
		    }
		    str = "";
		}
	    }while(!endTalk);
	}catch(IOException e) {
	    e.printStackTrace();
	}
    }
}
