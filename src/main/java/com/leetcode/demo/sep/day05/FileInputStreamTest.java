package com.leetcode.demo.sep.day05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {
        File fileSrc = new File("D:\\software\\idea_workspace\\leetcodeDemos\\src\\docs\\day05-NIO.md");
//        File destFIle = new File("D:\\software\\idea_workspace\\leetcodeDemos\\src\\docs\\day05-NIO-temp.md");
        FileInputStream inputStream = new FileInputStream(fileSrc);
//        FileOutputStream outputStream = new FileOutputStream(destFIle);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
//            outputStream.write(buffer, 0, len);
//            outputStream.write(buffer);
            String s = new String(buffer, 0, len);
            System.out.println(s);
        }
        inputStream.close();
//        outputStream.close();
    }
}
