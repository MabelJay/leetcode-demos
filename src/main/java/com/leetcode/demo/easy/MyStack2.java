package com.leetcode.demo.easy;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack2 {

    Deque<Integer> queue1;
    Deque<Integer> queue2;
    int temp;

    public MyStack2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        temp = 0;
    }

    public void push(int x) {
        queue1.offer(x);
        temp = x;
    }

    public int pop() {
        int size1 = queue1.size();
        int size2 = queue2.size();
        boolean flag = true;
        int index = 0;
        while (index < (size1 - 1)) {
            int val = queue1.poll();
            queue2.offer(val);
            temp = val;
            index++;
        }
        if (index == (size2 - 1)) return queue2.poll();
        while (index < (size2 - 1)) {
            flag = false;
            int val = queue2.poll();
            queue1.offer(val);
            temp = val;
            index++;
        }
        return flag ? queue1.poll() : queue2.poll();
    }

    public int top() {
        return this.temp;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
