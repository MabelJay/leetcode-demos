package com.leetcode.demo.easy;

import java.util.Arrays;

public class ArrayPairSum {

    public static void main(String[] args) {
        // 输入：nums = [6,2,6,5,1,2]
        //输出：9
        int[] nums = {1, 4, 3, 2};
        System.out.println(new ArrayPairSum().arrayPairSum(nums));
    }

    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
