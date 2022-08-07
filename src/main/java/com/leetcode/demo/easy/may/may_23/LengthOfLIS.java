package com.leetcode.demo.easy.may.may_23;

import java.util.Arrays;

public class LengthOfLIS {

    public static void main(String[] args) {
        // 输入：nums = [10,9,2,5,3,7,101,18]
        //输出：4

        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};

        // [1,3,6,7,9,4,10,5,6]
        // 6
        System.out.println(new LengthOfLIS().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
