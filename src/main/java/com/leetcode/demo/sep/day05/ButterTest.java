package com.leetcode.demo.sep.day05;

import java.nio.CharBuffer;

public class ButterTest {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(10);
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());

        buffer.put('a');
        buffer.put('b');
        buffer.put('c');

        System.out.println("position = " + buffer.position());
        buffer.flip();

        System.out.println("limit=" + buffer.limit());
        System.out.println("position=" + buffer.position());

        System.out.println(buffer.get());
        System.out.println("position=" + buffer.position());

        buffer.clear();
        System.out.println("limit=" + buffer.limit());
        System.out.println("position=" + buffer.position());
        System.out.println(buffer.get(2));

        System.out.println("position=" + buffer.position());
    }
}
