package com.lhg.test.gtan.begin.niosocket;

import java.net.*;
import java.nio.channels.*;
import java.nio.*;
import java.io.*;
public class Client {
    public static void main(String args[]) {
	new Client().connect();
    }

    public void connect() {
	try{
	    SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(),9999);
	    SocketChannel client = SocketChannel.open(socketAddress);
	    client.configureBlocking(false);
	     
	    ByteBuffer byteBuffer = ByteBuffer.allocate(50);
	    BufferedReader local = new BufferedReader(new InputStreamReader(System.in));
	    boolean isConnect = true;
	
	    int port = client.socket().getLocalPort();

	    System.out.println(port+"进入频道");
		
	    while(isConnect) {
		String str = local.readLine();

		String strSend = port+"说： "+str;		

		byteBuffer.clear();		
//		System.out.println(byteBuffer.position());
		byteBuffer.put(strSend.getBytes(),0,strSend.length());
		client.write(byteBuffer);
		
		byteBuffer.clear();
//		System.out.println(byteBuffer.position());
		int count = client.read(byteBuffer);
		if(count>=0) {
//                    String result = new String(byteBuffer.array());
//                    System.out.println("result length:"+result.length());
		    System.out.println(new String(byteBuffer.array()));
		}	
		
		if(str.equals("bye")) {
		     isConnect = false;
		     client.close();
		     System.out.println("连接关闭");
		}		
	    }
	}catch(IOException e) {
	     e.printStackTrace();
	}
    }
}

