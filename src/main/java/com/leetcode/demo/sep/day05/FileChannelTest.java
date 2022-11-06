package com.leetcode.demo.sep.day05;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class FileChannelTest {

    public static void main(String[] args) {
        File fileSrc = new File("D:\\software\\idea_workspace\\leetcodeDemos\\src\\docs\\day05-NIO.md");
        File fileDest = new File("D:\\software\\idea_workspace\\leetcodeDemos\\src\\docs\\day05-NIO-tmp.md");
        try (FileChannel inChannel = new FileInputStream(fileSrc).getChannel();
             FileChannel outChannel = new FileOutputStream(fileDest).getChannel()) {
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSrc.length());
            Charset charset = StandardCharsets.UTF_8;
            outChannel.write(buffer);
            buffer.clear();

            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
