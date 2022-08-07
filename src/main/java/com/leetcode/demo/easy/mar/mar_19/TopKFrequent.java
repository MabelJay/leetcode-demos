package com.leetcode.demo.easy.mar.mar_19;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        // 输入: nums = [1,1,1,2,2,3], k = 2
        //输出: [1,2]

        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {1};
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent(nums, 2)));
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent(nums2, 1)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((Comparator.comparingInt(Map.Entry::getValue)));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) minHeap.poll();
        }
        int[] arr = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll().getKey();
        }
        return arr;
    }
}
