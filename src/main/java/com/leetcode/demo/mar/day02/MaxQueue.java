package com.leetcode.demo.mar.day02;

import java.util.LinkedList;

class MaxQueue {

    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;

    public MaxQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public int max_value() {
        if (queue2.isEmpty()) return -1;
        return queue2.peekFirst();
    }

    public void push_back(int value) {
        queue1.offer(value);
        while (!queue2.isEmpty() && value > queue2.peekLast()) {
            queue2.pollLast();
        }
        queue2.offerLast(value);
    }

    public int pop_front() {
        if (queue1.isEmpty()) return -1;
        int ans = queue1.poll();
        if (ans == queue2.peekFirst()) {
            queue2.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        // 输入:
        //["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
        //[[],[1],[2],[],[],[]]
        //输出: [null,null,null,2,1,2]
        MaxQueue queue = new MaxQueue();
        queue.push_back(1);
        queue.push_back(2);
        System.out.println(queue.max_value());
        queue.pop_front();
        System.out.println(queue.max_value());
    }
}