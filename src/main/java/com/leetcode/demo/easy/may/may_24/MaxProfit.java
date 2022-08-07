package com.leetcode.demo.easy.may.may_24;

public class MaxProfit {

    public static void main(String[] args) {
        // 输入: [7,1,5,3,6,4]
        //输出: 5

        // 输入: [7,6,4,3,1]
        //输出: 0
        int[] prices = {};
        System.out.println(new MaxProfit().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
