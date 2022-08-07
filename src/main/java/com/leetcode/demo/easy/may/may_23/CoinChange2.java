package com.leetcode.demo.easy.may.may_23;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
        // 输入：amount = 5, coins = [1, 2, 5]
        //输出：4

        // 输入：amount = 3, coins = [2]
        //输出：0

        int[] coins = {1, 2, 5};
        System.out.println(new CoinChange2().change(5, coins));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
