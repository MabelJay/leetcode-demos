package com.leetcode.demo.apr.day30;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        // 输入：coins = [1, 2, 5], amount = 11
        //输出：3
        //解释：11 = 5 + 5 + 1

        // 输入：coins = [2], amount = 3
        //输出：-1
        int[] coins = {2};
        System.out.println(new CoinChange().coinChange(coins, 3));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
