package com.leetcode.demo.nov.day10;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        // 输入：amount = 5, coins = [1, 2, 5]
        //输出：4

        int[] coins = {1, 2, 5};
        System.out.println(new CoinChange().change(5, coins));
    }

    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return 0;

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}
