package com.leetcode.demo.apr.day20;

public class MaxSubArray {

    public static void main(String[] args) {
        // 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出：6
        //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

        // 输入：nums = [5,4,-1,7,8]
        //输出：23
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(new MaxSubArray().maxSubArray2(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            curSum += num;
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }
}
