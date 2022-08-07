package com.leetcode.demo.easy.may.may_01;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestArrayDeque {

    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("java");
        stack.push("hello");
        stack.push("world");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);

        Deque<String> queue = new ArrayDeque<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
