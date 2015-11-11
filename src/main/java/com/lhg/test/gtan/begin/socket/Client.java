package com.lhg.test.gtan.begin.socket;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String args[]) {
	try {	
	    Socket server = new Socket(InetAddress.getLocalHost(),5678);
 	    BufferedReader back = new BufferedReader(new InputStreamReader(server.getInputStream()));
	    BufferedReader local = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter writer = new PrintWriter(server.getOutputStream());
	    String strBack = "";
	    String strLocal = "";

	    while(true) {
		strLocal = local.readLine();
		/*这两行不能写道一起，应该先有个flush动作*/
//		strBack = back.readLine();
		writer.println(strLocal);
		writer.flush();
		strBack = back.readLine();
		System.out.println(strBack);
		if(strLocal.equals("end")) {
		    break;
		}
	    }   

	    server.close();
	    back.close();
	}catch(IOException e) {
	    e.printStackTrace();
	}		
    }
}
