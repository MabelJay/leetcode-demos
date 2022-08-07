package com.leetcode.demo.easy.apr.apr_14;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

class MyStack {

    Deque<Integer> queue1;
    Deque<Integer> queue2;
    int count;
    int topValue;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        count = 0;
        topValue = -1;
    }

    public void push(int x) {
        queue1.offer(x);
        count++;
        topValue = x;
    }

    public int pop() {
        if (empty()) return -1;
        int temp = 1;
        if (queue1.isEmpty()) {
            while (temp < count) {
                int val = queue2.poll();
                queue1.offer(val);
                temp++;
                topValue = val;
            }
            count--;
            return queue2.poll();
        } else {
            while (temp < count) {
                int val = queue1.poll();
                queue2.offer(val);
                temp++;
                topValue = val;
            }
            count--;
            return queue1.poll();
        }
    }

    public int top() {
        return topValue;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        // 输入：
        //["MyStack", "push", "push", "top", "pop", "empty"]
        //[[], [1], [2], [], [], []]
   /*     MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.empty());
        System.out.println(stack.pop());*/

        //["MyStack","push","pop","empty"]
        //[[],[1],[],[]]
        MyStack stack1 = new MyStack();
        stack1.push(1);
        stack1.push(2);
        System.out.println(stack1.top());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.empty());

        //["MyStack","push","push","pop","top"]
        //[[],[1],[2],[],[]]

        //["MyStack","push","push","top","pop","pop","empty"]
        //[[],[1],[2],[],[],[],[]]

    }
}