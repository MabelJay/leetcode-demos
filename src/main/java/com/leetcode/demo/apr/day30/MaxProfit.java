package com.leetcode.demo.apr.day30;

public class MaxProfit {

    public static void main(String[] args) {
        // 输入: prices = [1,2,3,0,2]
        //输出: 3

        // 输入: prices = [1]
        //输出: 0

        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(new MaxProfit().maxProfit2(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int size = prices.length;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;

        for (int i = 1; i < size; i++) {
            int temp = f0;
            f0 = Math.max(f0, f2 - prices[i]);
            f2 = Math.max(f1, f2);
            f1 = temp + prices[i];
        }
        return Math.max(f1, f2);
    }
}
