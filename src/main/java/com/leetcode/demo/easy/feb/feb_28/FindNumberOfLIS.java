package com.leetcode.demo.easy.feb.feb_28;

import java.util.Arrays;

public class FindNumberOfLIS {

    public static void main(String[] args) {
        // 输入: [1,3,5,4,7]
        //输出: 2
        int[] nums = {1, 3, 5, 4, 7};
        // 输入: [2,2,2,2,2]
        //输出: 5
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(nums));
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int len = nums.length;
        int[] dp = new int[len];
        int[] count = new int[len];
        int maxLen = 0;
        int ans = 0;
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        count[i] = count[j];
                        dp[i] = dp[j] + 1;
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = count[i];
            } else if (dp[i] == maxLen) {
                ans += count[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));
        return ans;
    }
}
