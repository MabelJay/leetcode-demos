package com.leetcode.demo.easy.feb.feb_13;

public class MaxProfitFreeze {

    public static void main(String[] args) {
        // 输入: prices = [1,2,3,0,2]
        //输出: 3
        //解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(new MaxProfitFreeze().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    public void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
