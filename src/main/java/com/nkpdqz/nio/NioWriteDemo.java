package com.nkpdqz.nio;

import jdk.management.resource.internal.inst.RandomAccessFileRMHooks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioWriteDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("test.txt","rw");
        FileChannel channel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        byteBuffer.clear();
        byteBuffer.put("nkpdqz".getBytes());
        byteBuffer.flip();
        while (byteBuffer.hasRemaining())
            channel.write(byteBuffer);
        channel.close();
        file.close();
    }
}
