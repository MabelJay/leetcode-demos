package com.leetcode.demo.easy.may.may_23;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        // 输入：cost = [10, 15, 20]
        //输出：15

        // 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
        //输出：6

        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];

        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }
}
