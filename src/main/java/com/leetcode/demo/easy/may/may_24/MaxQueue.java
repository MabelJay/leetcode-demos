package com.leetcode.demo.easy.may.may_24;

import java.util.LinkedList;

public class MaxQueue {

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

        while (!queue2.isEmpty() && queue2.peekLast() < value) {
            queue2.pollLast();
        }
        queue2.offerLast(value);
        queue1.offer(value);
    }

    public int pop_front() {
        if (queue1.isEmpty()) return -1;
        int ans = queue1.poll();
        if (ans == queue2.peekFirst()) {
            queue2.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        // 输入:
        //["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
        //[[],[1],[2],[],[],[]]
        //输出: [null,null,null,2,1,2]

        MaxQueue queue = new MaxQueue();
        queue.push_back(4);
        queue.push_back(3);
        queue.push_back(2);
        queue.push_back(5);
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
    }
}
