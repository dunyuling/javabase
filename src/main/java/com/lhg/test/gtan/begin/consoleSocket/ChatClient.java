package com.lhg.test.gtan.begin.consoleSocket;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ChatClient {
    private static final int PORT = 9000;
//    private ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String args[]) {
	new ChatClient();
    }

    public ChatClient() {
	try {
	    Socket socket = new Socket(InetAddress.getLocalHost(),PORT);
	    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//	    exec.execute(new Client(socket));
	    new Thread(new Client(socket)).start();
	    String strRecieve = "";
	    while((strRecieve = reader.readLine())!= null) {
		if(strRecieve.trim().equals("")) {
		     System.out.print("00000");
		}
		System.out.println(strRecieve);
	    }
	}catch(IOException e) {
	    e.printStackTrace();
	}
    }

    class Client implements Runnable {
	private Socket socket;

	public Client(Socket socket) {
	    this.socket = socket;
	}

	public void run() {
	    try{
	  	BufferedReader local = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
		boolean isConnected = false;      
		String msg = "";
	        while(!isConnected) {
                    msg = local.readLine();
		    if(msg!=null && !(msg.equals(""))) {
			writer.println(msg);
		    }	
                    if(msg.equals("bye")) {
                       // exec.shutdown();
                        socket.close();
                    }
	        }
	    }catch(IOException e) {
		e.printStackTrace();
	    }
	}
    }
}
