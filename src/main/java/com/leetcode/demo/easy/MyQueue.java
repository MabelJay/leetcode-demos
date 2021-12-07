package com.leetcode.demo.easy;


import java.util.Deque;
import java.util.LinkedList;

class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;
    int temp;

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                this.temp = x;
            }
        } else {
            this.temp = stack2.peek();
        }
        stack1.push(x);
    }

    public int pop() {
        if (empty()) {
            throw new RuntimeException("queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        int val = stack2.pop();
        if (!stack2.isEmpty()) {
            this.temp = stack2.peek();
        } else if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            this.temp = stack2.peek();
        }
        return val;
    }

    public int peek() {
        return this.temp;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}