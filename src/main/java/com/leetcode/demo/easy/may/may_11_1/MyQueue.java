package com.leetcode.demo.easy.may.may_11_1;

import java.util.Stack;

public class MyQueue<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public synchronized void enqueue(T item) {
        stack1.push(item);
    }

    public synchronized T deque() {
        if (stack1.isEmpty() && stack2.isEmpty()) return null;
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.deque());
        System.out.println(queue.deque());
        queue.enqueue(4);
        System.out.println(queue.deque());
    }
}
