package com.leetcode.demo.oct.day16;

import java.util.Arrays;

public class MaxProfit {

    public static void main(String[] args) {
        // 输入：[7,1,5,3,6,4]
        //输出：5

        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(new MaxProfit().maxProfit(prices));

        // method 2
        // 输入：prices = [7,1,5,3,6,4]
        //输出：7
        System.out.println(new MaxProfit().maxProfit5(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            maxProfit = Math.max(price - minPrice, maxProfit);
            minPrice = Math.min(price, minPrice);
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                if (prices[i] > prices[j]) {
                    dp[i] = Math.max(dp[j] + prices[i] - prices[j], dp[i]);
                }
            }
        }
        return dp[len - 1];
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit4(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);
            preCash = cash;
            preHold = hold;
        }
        return cash;
    }

    public int maxProfit5(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;

        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
