package com.leetcode.demo.easy.feb.feb_09;

import java.util.Arrays;
import java.util.Set;

public class CombinationSum4 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new CombinationSum4().combinationSum4(nums, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) dp[i] += dp[i - nums[j]];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target];
    }
}
