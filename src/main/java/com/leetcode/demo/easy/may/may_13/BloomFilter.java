package com.leetcode.demo.easy.may.may_13;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BloomFilter {

    public static void main(String[] args) throws Exception {
        System.out.println(Math.pow(2, 32));
        System.out.println(Math.pow(2, 32) / 8 / 1024 / 1024);
        System.out.println(Integer.toBinaryString(0xff));

        String a = "A";
        String b = new String("c");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(Arrays.toString(b.getBytes(StandardCharsets.UTF_8)));
    }
}
