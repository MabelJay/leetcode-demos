package com.leetcode.demo.easy.apr.apr_17;

import java.util.ArrayList;
import java.util.List;

public class RecentCounterTest {

    static class RecentCounter {

        int count;
        List<Integer> list;
        int min;
        int index;

        public RecentCounter() {
            count = 0;
            list = new ArrayList<>();
            min = 0;
            index = 0;
        }

        public int ping(int t) {
            count++;
            min = t - 3000;
            list.add(t);
            while (index < count) {
                if (list.get(index) >= min) return count - index;
                index++;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        // ["RecentCounter", "ping", "ping", "ping", "ping"]
        //[[], [1], [100], [3001], [3002]]
        //输出：
        //[null, 1, 2, 3, 3]

        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
}
