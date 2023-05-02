package com.leetcode.demo.apr.day25;

import java.util.Arrays;

public class MaxProfit1 {

    public static void main(String[] args) {
        // 输入：[7,1,5,3,6,4]
        //输出：5

        // 输入：prices = [7,6,4,3,1]
        //输出：0

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfit1().maxProfit3(prices));
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;

        int ans = 0;
        for (int i = 1; i < len; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
            } else dp[i] = dp[i - 1];
//            System.out.println(Arrays.toString(dp));
        }
        return dp[len - 1];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minVal = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minVal) {
                maxProfit = Math.max(maxProfit, prices[i] - minVal);
            } else minVal = prices[i];
        }
        return maxProfit;
    }
}
