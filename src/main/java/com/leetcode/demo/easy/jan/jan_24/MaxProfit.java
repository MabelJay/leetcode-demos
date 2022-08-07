package com.leetcode.demo.easy.jan.jan_24;

public class MaxProfit {

    public static void main(String[] args) {
        // 输入: prices = [7,1,5,3,6,4]
        //输出: 7

        // 输入: prices = [1,2,3,4,5]
        //输出: 4

        // 输入: prices = [7,6,4,3,1]
        //输出: 0
        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        System.out.println(new MaxProfit().maxProfit2(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                dp[i] = prices[i] - prices[i - 1] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int len = prices.length;
        int diff = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                diff += prices[i] - prices[i - 1];
            }
        }
        return diff;
    }
}
