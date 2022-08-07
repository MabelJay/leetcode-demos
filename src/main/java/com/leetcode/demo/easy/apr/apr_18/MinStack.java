package com.leetcode.demo.easy.apr.apr_18;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MinStack() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }

    public void push(int val) {
        this.stack1.push(val);
        if (this.stack2.isEmpty() || val <= this.stack2.peek()) stack2.push(val);
    }

    public void pop() {
        int val = this.stack1.pop();
        if (!this.stack2.isEmpty() && val == this.stack2.peek()) this.stack2.pop();
    }

    public int top() {
        return this.stack1.peek();
    }

    public int getMin() {
        return this.stack2.peek();
    }
}