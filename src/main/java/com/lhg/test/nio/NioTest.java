package com.lhg.test.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by liuhg on 16-6-3.
 */
public class NioTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/home/liuhg/workspace/javabase/src/main/java/com/lhg/test/nio/n.txt", "rw");

            FileChannel fileChannel = randomAccessFile.getChannel();


            ByteBuffer buffer = ByteBuffer.allocate(48);
            byte[] bytes = new byte[48];

            int bytesRead = fileChannel.read(buffer);
            while (bytesRead != -1) {
                System.out.println("\nRead: " + bytesRead);
//                buffer.flip();
                buffer.clear();

                buffer = buffer.get(bytes, 48 - bytesRead, bytesRead);
                for (byte b : bytes) {
                    System.out.print((char) b);
                }

                /*while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }*/

                buffer.clear();
                bytesRead = fileChannel.read(buffer);
            }
            fileChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
