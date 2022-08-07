package com.leetcode.demo.easy.may.may_28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {

    public static void main(String[] args) {
        // 输入: nums = [0,1]
        //输出: 2

        // 输入: nums = [0,1,0]
        //输出: 2

        // [1,1,1,1,1,1,1,1]
        int[] nums = {0, 1};
        System.out.println(new FindMaxLength().findMaxLength2(nums));
    }

    public int findMaxLength(int[] nums) {
        int[] sum = new int[nums.length + 1];
        int maxLen = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            sum[i] += nums[i - 1] == 0 ? sum[i - 1] - 1 : sum[i - 1] + 1;
            if (map.containsKey(sum[i])) {
                maxLen = Math.max(maxLen, i - map.get(sum[i]));
            } else map.put(sum[i], i);
        }
        System.out.println(Arrays.toString(sum));
        return Math.max(maxLen, 0);
    }

    public int findMaxLength2(int[] nums) {
        int maxLen = Integer.MIN_VALUE;
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) counter++;
            else counter--;
            if (map.containsKey(counter)) maxLen = Math.max(maxLen, i - map.get(counter));
            else map.put(counter, i);
        }
        return Math.max(maxLen, 0);
    }
}
