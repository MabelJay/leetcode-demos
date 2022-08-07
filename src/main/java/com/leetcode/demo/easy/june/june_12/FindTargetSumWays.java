package com.leetcode.demo.easy.june.june_12;

import java.util.Arrays;

public class FindTargetSumWays {

    int count;

    public static void main(String[] args) {
        // 输入：nums = [1,1,1,1,1], target = 3
        //输出：5

        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(new FindTargetSumWays().findTargetSumWays3(nums, 3));

        // 输入：nums = [1], target = 1
    }

    public int findTargetSumWays(int[] nums, int target) {
        count = 0;
        traverse(nums, target, 0);
        return count;
    }

    public void traverse(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                count++;
            }
            return;
        }

        traverse(nums, target - nums[index], index + 1);
        traverse(nums, target + nums[index], index + 1);
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) return 0;
        int neg = diff / 2;
        int[][] dp = new int[nums.length + 1][neg + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][neg];
    }

    public int findTargetSumWays3(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) return 0;
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= 0; j--) {
                if (j >= num) dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }
}
