package com.leetcode.demo.easy.dec.dec_24;

import java.util.*;

/*
给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。

你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class FindShortestSubArray {

    public static void main(String[] args) {
        //输入：nums = [1,2,2,3,1]
        //输出：2

        //输入：nums = [1,2,2,3,1,4,2]
        //输出：6

        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(new FindShortestSubArray().findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        // count frequency
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            if (map.containsKey(temp)) {
                int[] tmpArr = map.get(temp);
                tmpArr[0]++;
                tmpArr[2] = i;
            } else {
                map.put(temp, new int[]{1, i, i});
            }
        }

        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] tmpArr = entry.getValue();
            if (tmpArr[0] > maxNum) {
                maxNum = tmpArr[0];
                minLen = tmpArr[2] - tmpArr[1] + 1;
            } else if (tmpArr[0] == maxNum) {
                minLen = Math.min(minLen, tmpArr[2] - tmpArr[1] + 1);
            }
        }
        return minLen;
    }
}
