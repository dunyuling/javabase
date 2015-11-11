package com.lhg.test.gtan.begin.consoleSocket;

import java.io.*;
import java.util.*;
import java.net.*;
import java.util.concurrent.*;
import java.lang.*;

public class ChatServer {
    private static final int PORT = 9000;
    private Deque<Socket> usedSocket = new ConcurrentLinkedDeque<Socket>();
    public static void main(String args[]) {
	new ChatServer();	
    }

    public ChatServer() {
	try {
	    ServerSocket server = new ServerSocket(PORT);
	    ExecutorService exec = Executors.newCachedThreadPool();
	    while(true) {
		Socket client = server.accept();
		usedSocket.add(client);
		exec.execute(new Chat(client));
	    }
	}catch(IOException e) {	
	    e.printStackTrace();
	}
    }


    class Chat implements Runnable {
	private Socket socket ;
	private PrintWriter writer = null;

	public Chat(Socket socket) {
	    this.socket = socket;
	}

	public void run() {
	    try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		String msg = socket.getPort()+"进入聊天室,当前共有"+usedSocket.size()+"人";
		sendMessage(msg);
		boolean isConnected = true;
		while(isConnected){
		    msg = reader.readLine();
                    if(msg.trim().equals("bye")) {
                        usedSocket.remove(socket);
                        socket.close();
			msg = this.socket.getPort()+"离开聊天室，当前共有"+usedSocket.size()+"人";
			sendMessage(msg);
                        isConnected = false;	
                    } else {
                        if(msg != null) {
			    msg = this.socket.getPort()+"说: "+msg;
                            sendMessage(msg);
                        }
                    }
		} 
	    }catch(Exception e) {
		e.printStackTrace();		
	    }
	}     

	private void sendMessage(String msg) {
	     System.out.println(msg);
	     for(Socket client : usedSocket) {
		  try {	
		      writer = new PrintWriter(client.getOutputStream(),true); 
		  }catch(IOException e) {
		      e.printStackTrace();
		  }
		  if(client != socket) {
	              writer.println(msg);
		  }
             }
	}
    }   
}
