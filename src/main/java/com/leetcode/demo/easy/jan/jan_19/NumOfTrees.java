package com.leetcode.demo.easy.jan.jan_19;

public class NumOfTrees {

    public static void main(String[] args) {
        System.out.println(new NumOfTrees().numTrees(3));
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
