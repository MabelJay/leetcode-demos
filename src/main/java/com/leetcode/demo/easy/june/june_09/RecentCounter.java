package com.leetcode.demo.easy.june.june_09;

import java.util.LinkedList;

class RecentCounter {

    LinkedList<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }

    public static void main(String[] args) {
        // 输入：
        //inputs = ["RecentCounter", "ping", "ping", "ping", "ping"]
        //inputs = [[], [1], [100], [3001], [3002]]
        //输出：
        //[null, 1, 2, 3, 3]

        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
}