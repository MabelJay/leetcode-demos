package com.leetcode.demo.easy.apr.apr_17;

import java.util.ArrayList;
import java.util.LinkedList;

public class RecentCounterTest2 {

    static class RecentCounter {
        LinkedList<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
