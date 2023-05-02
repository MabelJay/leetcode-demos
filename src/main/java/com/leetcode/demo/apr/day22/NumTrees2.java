package com.leetcode.demo.apr.day22;

import java.util.Arrays;

public class NumTrees2 {

    public static void main(String[] args) {
        // 输入：n = 3
        //输出：5

        // n=2
        // output: 2
        System.out.println(new NumTrees2().numTrees(3));
    }

    public int numTrees(int n) {
        if (n < 2) return n;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
