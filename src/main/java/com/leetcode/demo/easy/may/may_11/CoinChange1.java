package com.leetcode.demo.easy.may.may_11;

import java.util.Arrays;

public class CoinChange1 {

    public static void main(String[] args) {
        // 输入：coins = [1, 2, 5], amount = 11
        //输出：3
        //解释：11 = 5 + 5 + 1

        // 输入：coins = [2], amount = 3
        //输出：-1

        // 输入：coins = [1], amount = 0
        //输出：0

        int[] coins = {2};
        System.out.println(new CoinChange1().coinChange(coins, 3));
    }

    public int coinChange(int[] coins, int amount) {
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
        System.out.println(Arrays.toString(dp));
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
