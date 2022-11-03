package com.leetcode.demo.sep.day03;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        // 输入：m = 3, n = 7
        //输出：28
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
