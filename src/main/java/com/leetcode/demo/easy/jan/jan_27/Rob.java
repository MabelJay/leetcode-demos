package com.leetcode.demo.easy.jan.jan_27;

import java.util.Arrays;

public class Rob {

    public static void main(String[] args) {
        // 输入：[1,2,3,1]
        //输出：4

        // 2,7,9,3,1
        // 12
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Rob().rob2(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[len - 1];
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];

        int len = nums.length;
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int cur = Math.max(second, nums[i] + first);
            first = second;
            second = cur;
        }
        return second;
    }
}
