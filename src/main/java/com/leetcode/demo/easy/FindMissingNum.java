package com.leetcode.demo.easy;

import java.util.Arrays;
import java.util.List;

public class FindMissingNum {

    public static void main(String[] args) {
        // 9,6,4,2,3,5,7,0,1
        // 8

        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        FindMissingNum missingNum = new FindMissingNum();
        System.out.println(missingNum.missingNumber3(nums));
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int sum = len * (len + 1) / 2;
        for (Integer num : nums) {
            sum -= num;
        }
        return sum;
    }

    public int missingNumber2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    public int missingNumber3(int[] nums) {
        int val = 0;
        for (int i = 0; i <= nums.length; i++) {
            val ^= i;
        }

        for (Integer i : nums) {
            val ^= i;
        }
        return val;
    }
}
