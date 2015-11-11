package com.lhg.test.gtan.begin.socket;

import java.net.*;
import java.io.*;
import java.lang.*;

public class Server {
    public static void main(String args[]) {
	new Server();
    }
   
    public Server() {
	try {
	    ServerSocket server = new ServerSocket(5678);
//	    BufferedReader local = new BufferedReader(new InputStreamReader(System.in)) ;
	    String strLocal = "";
	    while(true) {
//		strLocal = local.readLine();
		Socket client = server.accept();
		new Thread(new HandleThread(client)).start();
		if(strLocal.equals("end")) {
		     System.out.println("服务器关闭");
		     break;
		}
	    }
	}catch(IOException e) {
	    e.printStackTrace();
	} 
    }

    class HandleThread implements Runnable {      
	private Socket client;
	public HandleThread(Socket client) {
            this.client = client;
	}
        public void run() { 
	    try {
       	        BufferedReader recieve = new BufferedReader(new InputStreamReader(client.getInputStream()));
	        PrintWriter writer = new PrintWriter(client.getOutputStream(),true);
	
  	        String strRecieve = "";
	        while(true){
        	    strRecieve = recieve.readLine();
		    System.out.println(client.toString());
		    if(strRecieve.equals("end")) {
		        client.close();
		        System.out.println();
		         break;
		    }
  		    writer.println("client: "+strRecieve);
                }
                client.close();
	    }catch(Exception e) {
	        e.printStackTrace();
	    }
        }  
    }  
}

