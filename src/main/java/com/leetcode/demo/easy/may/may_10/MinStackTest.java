package com.leetcode.demo.easy.may.may_10;

import java.util.LinkedList;

public class MinStackTest {

    static class MinStack {

        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;

        public MinStack() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void push(int x) {
            stack1.push(x);
            if (!stack2.isEmpty()) {
                stack2.push(x < stack2.peek() ? x : stack2.peek());
            } else stack2.push(x);
        }

        public void pop() {
            if (!stack1.isEmpty()) {
                stack2.pop();
                stack1.pop();
            }
        }

        public int top() {
            return stack1.isEmpty() ? -1 : stack1.peek();
        }

        public int min() {
            return stack2.isEmpty() ? -1 : stack2.peek();
        }
    }

    public static void main(String[] args) {
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
