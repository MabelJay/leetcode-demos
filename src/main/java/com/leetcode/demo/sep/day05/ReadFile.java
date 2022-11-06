package com.leetcode.demo.sep.day05;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\software\\idea_workspace\\leetcodeDemos\\src\\docs\\day05-NIO.md");

        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(102400);
        while (fileChannel.read(buffer)!=-1) {
            buffer.flip();
            Charset charset = StandardCharsets.UTF_8;
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);

            System.out.print(charBuffer);
            buffer.clear();
        }

        fileChannel.close();
    }
}
