package com.leetcode.demo.easy.apr.apr_18;

import java.util.LinkedList;

public class MinStackTest {

    static class MinStack {

        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;

        public MinStack() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void push(int val) {
            stack1.push(val);
            if (stack2.isEmpty() || stack2.peek() >= val) {
                stack2.push(val);
            }
        }

        public void pop() {
            int val = stack1.pop();
            if (!stack2.isEmpty() && val == stack2.peek()) stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }

    public static void main(String[] args) {
        // ["MinStack","push","push","push","getMin","pop","top","getMin"]
        //[[],[-2],[0],[-3],[],[],[],[]]
        //
        //输出：
        //[null,null,null,null,-3,null,0,-2]

        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
//        System.out.println(stack.getMin());
        stack.pop();
//        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

        // ["MinStack","push","push","push","getMin","pop","getMin"]
        //[[],[0],[1],[0],[],[],[]]
        //[null,null,null,null,null,null,-1024,null,-1024,null,512]

        //["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
        //[[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
    }
}
