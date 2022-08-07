package com.leetcode.demo.easy.apr.apr_15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeastInterval {

    public static void main(String[] args) {
        // 输入：tasks = ["A","A","A","B","B","B"], n = 2
        //输出：8

        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(new LeastInterval().leastInterval2(tasks, 2));
    }

    public int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            max = Math.max(max, map.get(ch));
        }

        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val == max) maxCount++;
        }
        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            maxExec = Math.max(maxExec, freq.get(ch));
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}
