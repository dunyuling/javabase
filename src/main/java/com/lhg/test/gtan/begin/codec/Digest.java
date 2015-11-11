package com.lhg.test.gtan.begin.codec;

import java.io.*;
import org.apache.commons.codec.digest.*;
public class Digest {
    public static void main(String args[]) {
	new Digest().encrypt();
    }
 
    public void encrypt() {
	try {
	    System.out.println("请验证SHA256加密算法，输入end退出！");
	    BufferedReader local = new BufferedReader(new InputStreamReader(System.in));
	    String str = "";
	    boolean endFlag = false;
	    do{
		str = local.readLine();
		System.out.println(Sha2Crypt.sha256Crypt(str.getBytes()));	
		if(str.trim().equals("end")) {
		    endFlag = true;
		}
	    }while(!endFlag);
	}catch(IOException e) {
	    e.printStackTrace();
	}
    }
}
