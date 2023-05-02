package com.leetcode.demo.apr.day30;

import java.util.Arrays;

public class LengthOfLIS {

    public static void main(String[] args) {
        // 输入：nums = [10,9,2,5,3,7,101,18]
        //输出：4

        // 输入：nums = [0,1,0,3,2,3]
        //输出：4

        // 输入：nums = [7,7,7,7,7,7,7]
        //输出：1

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LengthOfLIS().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;

        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
