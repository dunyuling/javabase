package com.lhg.test.gtan.begin.niosocket;

import java.io.*;
import java.nio.channels.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.lang.*;
public class Server {
    public static void main(String args[]) {
	new Server().server();	
    }

    public void server() {
	try {
	    Selector selector = Selector.open();
	    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
	    serverSocketChannel.configureBlocking(false);
	    ServerSocket serverSocket = serverSocketChannel.socket();
	    SocketAddress socketAddress = new InetSocketAddress(9999);
   	    serverSocket.bind(socketAddress);	
	    serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
	    while(true) {
		selector.select();
		Set<SelectionKey> selectionKeys = selector.selectedKeys();
		Iterator<SelectionKey> iterator = selectionKeys.iterator();
		ByteBuffer recieveBuffer = ByteBuffer.allocate(50);
		ByteBuffer sendBuffer = ByteBuffer.allocate(50);
//		SocketChannel socketChannel = null;
		while(iterator.hasNext()) {
		    SelectionKey key = iterator.next();
		    if((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
			System.out.println("+++++++++++++");
			ServerSocketChannel subServerSocketChannel = (ServerSocketChannel)key.channel();
			SocketChannel ready = subServerSocketChannel.accept();
			ready.configureBlocking(false);
			ready.register(selector,SelectionKey.OP_READ);
			iterator.remove();
		    } else if((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
			System.out.println("-----------------");
			SocketChannel in = (SocketChannel)key.channel();
			recieveBuffer.clear();
			int count = in.read(recieveBuffer);
			if(count == -1 ) break;
			if(count>0) {
			    String msg = in.socket().getPort()+"说："+ new String(recieveBuffer.array());
			    System.out.println(msg);
			    in.register(selector,SelectionKey.OP_WRITE);
			}	
				
		    } else if((key.readyOps() & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE) {
			System.out.println("*************");
			SocketChannel out = (SocketChannel)key.channel();
			//System.out.println(sendBuffer.position());
			sendBuffer.clear();
			sendBuffer.put(new String(recieveBuffer.array()).getBytes());
			//sendBuffer.flip();
			out.write(sendBuffer);
			out.register(selector,SelectionKey.OP_READ);
		    }
		}
	
	    }    
	}catch(IOException e) {
	    e.printStackTrace();
	}
    }
}
