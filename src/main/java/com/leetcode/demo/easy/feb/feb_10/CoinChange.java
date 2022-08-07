package com.leetcode.demo.easy.feb.feb_10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoinChange {

    public static void main(String[] args) {
        // 输入：coins = [1, 2, 5], amount = 11
        //输出：3
        //解释：11 = 5 + 5 + 1
        int[] coins = {1, 2, 5};
        System.out.println(new CoinChange().coinChange(coins, 5));
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
