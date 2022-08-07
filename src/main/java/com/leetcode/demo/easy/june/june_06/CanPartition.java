package com.leetcode.demo.easy.june.june_06;

import java.util.*;

public class CanPartition {

    public static void main(String[] args) {
        // 输入：nums = [1,5,11,5]
        //输出：true

        // 输入：nums = [1,2,3,5]
        //输出：false

        // [14,9,8,4,3,2]
        // true

        int[] nums = {14, 9, 8, 4, 3, 2};
        System.out.println(new CanPartition().canPartition3(nums));
    }

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) return false;

        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        if (sum % 2 != 0 || max > sum / 2) return false;

        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];
    }

    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length < 2) return false;

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        return dfs(nums, 0, sum / 2);
    }

    public boolean dfs(int[] nums, int index, int sum) {
        if (sum == 0) return true;
        if (index == nums.length) return false;

        if (nums[index] <= sum) {
            boolean flag = dfs(nums, index + 1, sum - nums[index]);
            if (flag) return true;
        }
        return dfs(nums, index + 1, sum);
    }

    public boolean canPartition3(int[] nums) {
        if (nums == null || nums.length < 2) return false;

        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        if (sum % 2 != 0 || max > sum / 2) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}
