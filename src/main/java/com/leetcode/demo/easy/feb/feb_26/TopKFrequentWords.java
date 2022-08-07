package com.leetcode.demo.easy.feb.feb_26;

import java.util.*;

public class TopKFrequentWords {

    static class Pair {
        String word;
        int frequency;
    }

    static class MinHeapComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            if (o1.getValue() == o2.getValue()) {
                return o2.getKey().compareTo(o1.getKey());
            }
            return o1.getValue() - o2.getValue();
        }
    }

    public static void main(String[] args) {
        // 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
        //输出: ["i", "love"]

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        // 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
        //输出: ["the", "is", "sunny", "day"]

        // ["i","love","leetcode","i","love","coding"]
        //2

        // ["i","love","leetcode","i","love","coding"]
        //3
        String[] word2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] word3 = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] word4 = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(new TopKFrequentWords().topKFrequent(words, 2));
        System.out.println("leetcode".compareTo("coding"));
        System.out.println(new TopKFrequentWords().topKFrequent3(words, 2));
    }

    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }

        Collections.sort(list, (o1, o2) -> map.get(o1) == map.get(o2) ? o1.compareTo(o2) : map.get(o2) - map.get(o1));
        return list.subList(0, k);
    }

    public List<String> topKFrequent3(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(((o1, o2) -> o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue()));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) queue.poll();
        }

        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().getKey());
        }
        Collections.reverse(list);
        return list;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
//        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((Comparator.comparingInt(Map.Entry::getValue)));
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new MinHeapComparator());
        int count = 0;
        while (count < k) {
            queue.add(iterator.next());
            count++;
        }
        System.out.println(queue);
        System.out.println("queue peek=" + queue.peek());
        while (count < map.size()) {
            Map.Entry<String, Integer> entry1 = iterator.next();
            // || (entry1.getValue() == queue.peek().getValue() && entry1.getKey().compareTo(queue.peek().getKey()) > 0)
//            if (entry1.getValue() > queue.peek().getValue() || (entry1.getValue() == queue.peek().getValue() && entry1.getKey().compareTo(queue.peek().getKey()) < 0)) {
            queue.offer(entry1);
            if (queue.size() > k) {
                queue.poll();
            }
            count++;
        }
        System.out.println("queue peek=" + queue.peek());
        System.out.println(Arrays.toString(queue.toArray()));
        List<String> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            resList.add(queue.poll().getKey());
        }
        Collections.reverse(resList);
        return resList;
    }
}
