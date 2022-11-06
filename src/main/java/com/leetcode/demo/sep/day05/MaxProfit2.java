package com.leetcode.demo.sep.day05;

public class MaxProfit2 {

    public static void main(String[] args) {
        // 输入：prices = [7,1,5,3,6,4]
        //输出：7

        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(new MaxProfit2().maxProfit2(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
        }
        return dp[len - 1];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
