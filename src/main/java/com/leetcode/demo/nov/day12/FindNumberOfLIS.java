package com.leetcode.demo.nov.day12;

import java.util.Arrays;

public class FindNumberOfLIS {

    public static void main(String[] args) {
        // 输入: [1,3,5,4,7]
        //输出: 2

        // 输入: [2,2,2,2,2]
        //输出: 5

        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(nums));
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[] dp = new int[len];
        int[] count = new int[len];

        int maxLen = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = count[i];
            } else if (dp[i] == maxLen) {
                ans += count[i];
            }
        }
        return ans;
    }
}
