package com.leetcode.demo.easy.apr.apr_25;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        // 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
        //输出: ["i", "love"]

        // 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
        // 输出: ["the", "is", "sunny", "day"]
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(new TopKFrequent().topKFrequent(words, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o2.getValue() == o1.getValue()) {
                return o2.getKey().compareTo(o1.getKey());
            }
            return o1.getValue() - o2.getValue();
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> resList = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            resList.add(minHeap.poll().getKey());
        }
        Collections.reverse(resList);
        return resList;
    }
}
