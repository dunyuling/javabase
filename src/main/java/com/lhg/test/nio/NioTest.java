package com.lhg.test.nio;

import java.io.*;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * Created by liuhg on 16-6-3.
 */
public class NioTest {
    public static void main(String[] args) {

        testWrite3();
//        testPrint();

        /*System.out.println("main: " + Thread.currentThread().hashCode());
        Timer timer = new Timer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread: " + Thread.currentThread().hashCode());
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().hashCode());
                    }
                },30,20);
            }
        }).start();*/
    }

    private static void testPrint() {
        try {
            RandomAccessFile sourceAccessFile = new RandomAccessFile("/home/liuhg/workspace/javabase/src/main/java/com/lhg/test/nio/source.txt", "rw");
            FileChannel fileChannel = sourceAccessFile.getChannel();


            ByteBuffer buffer = ByteBuffer.allocate(48);
            byte[] bytes = new byte[48];

            int bytesRead = fileChannel.read(buffer);
            while (bytesRead != -1) {
//                System.out.println("\nRead: " + bytesRead);
                buffer.flip();


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

    private static void testWrite() {
        try {
            RandomAccessFile sourceAccessFile = new RandomAccessFile("/home/liuhg/workspace/javabase/src/main/java/com/lhg/test/nio/source.txt", "rw");
            RandomAccessFile destAccessFile = new RandomAccessFile("/home/liuhg/workspace/javabase/src/main/java/com/lhg/test/nio/dest.txt", "rw");
            FileChannel sourceAccessFileChannel = sourceAccessFile.getChannel();
            FileChannel destAccessFileChannel = destAccessFile.getChannel();


            ByteBuffer buffer = ByteBuffer.allocate(48);
            int bytesRead = sourceAccessFileChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                destAccessFileChannel.write(buffer);

                buffer.clear();
                bytesRead = sourceAccessFileChannel.read(buffer);
            }
            sourceAccessFile.close();
            sourceAccessFileChannel.close();
            destAccessFile.close();
            destAccessFileChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testWrite2() {
        try {
            File sourceFile = new File("/home/liuhg/workspace/javabase/src/main/java/com/lhg/test/nio/source.txt");
            FileInputStream fileInputStream = new FileInputStream(sourceFile);

            File destFile = new File("/home/liuhg/workspace/javabase/src/main/java/com/lhg/test/nio/dest.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);


            byte[] tempBuffer = new byte[2048];
            int count = 0;
            while ((count = fileInputStream.read(tempBuffer)) != -1) {
                fileOutputStream.write(tempBuffer, 0, count);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testWrite3() {
        try {
            RandomAccessFile destAccessFile = new RandomAccessFile("/home/liuhg/workspace/javabase/src/main/java/com/lhg/test/nio/dest.txt", "rw");
            FileChannel destAccessFileChannel = destAccessFile.getChannel();

            File sourceFile = new File("/home/liuhg/workspace/javabase/src/main/java/com/lhg/test/nio/source.txt");
            FileInputStream fileInputStream = new FileInputStream(sourceFile);

            ByteBuffer byteBuffer = ByteBuffer.allocate(256);
            byte[] tempBuffer = new byte[256];
            int count = 0;
            int totalCount = 0;

            destAccessFile.seek(destAccessFile.length());
            while ((count = fileInputStream.read(tempBuffer)) != -1) {
//                byteBuffer = ByteBuffer.wrap(tempBuffer);
                byteBuffer.put(tempBuffer, 0, count);

                totalCount += count;
                byteBuffer.flip();
                System.out.println("limit: " + byteBuffer.limit() + "\t count: " + count + " \t position: " + byteBuffer.position() + " \t totalCount: " + totalCount);

                destAccessFileChannel.write(byteBuffer);
                byteBuffer.clear();
            }


            fileInputStream.close();

//            destAccessFileChannel.force(true);
            destAccessFile.close();

            destAccessFileChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testWrite4() {
        try {
            RandomAccessFile sourceAccessFile = new RandomAccessFile("/home/liuhg/workspace/javabase/src/main/java/com/lhg/test/nio/source.txt", "rw");
            FileChannel fileChannel = sourceAccessFile.getChannel();

            FileOutputStream fileOutputStream = new FileOutputStream("/home/liuhg/workspace/javabase/src/main/java/com/lhg/test/nio/dest.txt");

            ByteBuffer buffer = ByteBuffer.allocate(48);
            byte[] bytes = new byte[48];

            int bytesRead = fileChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();

                buffer = buffer.get(bytes, 48 - bytesRead, bytesRead);
                fileOutputStream.write(Arrays.copyOfRange(bytes, 48 - bytesRead, 48));
                System.out.println("bytesRead: " + bytesRead + " \t length: " + bytes.length + " \t limit: " + buffer.limit());

//                buffer.clear();
                bytesRead = fileChannel.read(buffer);
            }
            fileOutputStream.flush();
            fileChannel.force(true);
            fileChannel.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
