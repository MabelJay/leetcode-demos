package com.leetcode.demo.easy.feb.feb_12;

import java.util.Arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        // 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出: 6
        //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

        // [-3,-2,0,-1]
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-3, -2, 0, -1};
        System.out.println(new MaxSubArray().maxSubArray(nums));
        System.out.println(new MaxSubArray().maxSubArray2(nums));
        System.out.println(new MaxSubArray().maxSubArray3(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSum = nums[0], thisSum = 0;
        for (int num : nums) {
            thisSum += num;
            if (thisSum > maxSum) maxSum = thisSum;
            if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxNum = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            maxNum = Math.max(maxNum, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return maxNum;
    }

    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre = nums[0];
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = pre > 0 ? pre + nums[i] : nums[i];
            maxNum = Math.max(maxNum, pre);
        }
        return maxNum;
    }
}
