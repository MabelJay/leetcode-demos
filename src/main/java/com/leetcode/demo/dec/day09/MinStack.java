package com.leetcode.demo.dec.day09;

import java.util.LinkedList;

class MinStack {

    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public MinStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) stack2.push(x);
        else {
            int min = stack2.peek();
            stack2.push(Math.min(x, min));
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            stack1.pop();
            stack2.pop();
        }
    }

    public int top() {
        return stack1.isEmpty() ? -1 : stack1.peek();
    }

    public int min() {
        return stack2.isEmpty() ? -1 : stack2.peek();
    }

    public static void main(String[] args) {
        // MinStack minStack = new MinStack();
        //minStack.push(-2);
        //minStack.push(0);
        //minStack.push(-3);
        //minStack.min();   --> 返回 -3.
        //minStack.pop();
        //minStack.top();      --> 返回 0.
        //minStack.min();   --> 返回 -2.

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}