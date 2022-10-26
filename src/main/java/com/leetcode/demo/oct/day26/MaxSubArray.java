package com.leetcode.demo.oct.day26;

import java.util.Arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        // 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出：6

        int[] nums = {-1};
        System.out.println(new MaxSubArray().maxSubArray2(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSum = nums[0];
        int tmpSum = 0;
        for (int num : nums) {
            tmpSum = Math.max(tmpSum + num, num);
            maxSum = Math.max(tmpSum, maxSum);
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] += dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
