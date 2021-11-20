package com.leetcode.demo.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoNumSum {
    public static void main(String[] args) {
        int[] nums = {2, 11, 15, 7, 9};
        int target = 9;
        System.out.println(Arrays.toString(new TwoNumSum().twoSum(nums, target)));
//        System.out.println(Arrays.toString(new TwoNumSum().twoSum1(nums, target)));
    }

    // < O(n^2)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    // O(n^2)
    public int[] twoSum1(int[] nums, int target) {
        int[] resultArr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    resultArr[0] = i;
                    resultArr[1] = j;
                    return resultArr;
                }
            }
        }
        return null;
    }
}
