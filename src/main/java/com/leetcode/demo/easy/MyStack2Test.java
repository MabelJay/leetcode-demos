package com.leetcode.demo.easy;

public class MyStack2Test {
    public static void main(String[] args) {
        /**
         * Your MyStack object will be instantiated and called as such:
         * MyStack obj = new MyStack();
         * obj.push(x);
         * int param_2 = obj.pop();
         * int param_3 = obj.top();
         * boolean param_4 = obj.empty();
         */

        MyStack2 stack2 = new MyStack2();
        stack2.push(1);
        stack2.push(2);
        System.out.println(stack2.pop());
        System.out.println(stack2.top());
        System.out.println(stack2.pop());
        System.out.println(stack2.empty());
    }
}
