package com.leetcode.demo.easy.may.may_11;

public class CollectCoins {

    public static void main(String[] args) {
        int[] choices = {1, 2, 5};

        System.out.println(new CollectCoins().waysOfCollectCoins(choices, 3));
    }

    public int waysOfCollectCoins(int[] choices, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 0;
        for (int i = 1; i <= sum; i++) {
            dp[i] = 1;
            for (int j = 0; j < choices.length; j++) {
                if (i >= choices[j]) {
                    dp[i] = Math.max(dp[i], dp[i - choices[j]] + 1);
                }
            }
        }
        return dp[sum];
    }
}
