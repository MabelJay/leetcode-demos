package com.leetcode.demo.oct.day19;

public class MaxProfit {

    public static void main(String[] args) {
        // 输入：prices = [3,3,5,0,0,3,1,4]
        //输出：6

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new MaxProfit().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;

        for (int i = 1; i < len; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
