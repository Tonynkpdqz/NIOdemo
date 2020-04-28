package com.nkpdqz.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class NioDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("test.txt","rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.clear();
        //int read = channel.read(buffer);
        while (channel.read(buffer) != -1){
            buffer.flip();
            System.out.println("123");
            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }
            buffer.clear();
        }
    }
}
