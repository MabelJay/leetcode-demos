package com.leetcode.demo.easy.feb.feb_16;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
        // 输入：amount = 5, coins = [1, 2, 5]
        //输出：4
        //解释：有四种方式可以凑成总金额：

        //500
        //[1,2,5]
        // 12701
        int[] coins = {1, 2, 5};
        System.out.println(new CoinChange2().change(500, coins));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
