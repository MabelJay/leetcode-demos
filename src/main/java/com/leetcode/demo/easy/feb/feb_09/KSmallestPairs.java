package com.leetcode.demo.easy.feb.feb_09;

import java.util.*;

public class KSmallestPairs {

    public static void main(String[] args) {
        // 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        //输出: [1,2],[1,4],[1,6]

        // 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
        //输出: [1,1],[1,1]

        // 输入: nums1 = [1,2], nums2 = [3], k = 3
        //输出: [1,3],[2,3]
        // [1,1,2]
        //[1,2,3]
        //10
        // [[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]]
        // [[1, 1], [1, 2], [1, 3], [1, 1], [1, 2], [1, 3], [2, 1], [2, 2], [2, 3]]

        // [1,2,4,5,6]
        //[3,5,7,9]
        //3
        // [[1,3],[2,3],[1,5]]
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        System.out.println(new KSmallestPairs().kSmallestPairs(nums1, nums2, 3));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> resList = new ArrayList<>();

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);

        for (int i = 0; i < Math.min(m, k); i++) {
            maxHeap.add(new int[]{i, 0});
        }

        while (k > 0 && !maxHeap.isEmpty()) {
            int[] indexPair = maxHeap.poll();
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(nums1[indexPair[0]]);
            tmpList.add(nums2[indexPair[1]]);
            resList.add(tmpList);
            if (indexPair[1] + 1 < n) {
                maxHeap.add(new int[]{indexPair[0], indexPair[1] + 1});
            }
            k--;
        }
        return resList;
    }
}
