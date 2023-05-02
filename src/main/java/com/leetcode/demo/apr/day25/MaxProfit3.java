package com.leetcode.demo.apr.day25;

public class MaxProfit3 {

    public static void main(String[] args) {
        // 输入：prices = [3,3,5,0,0,3,1,4]
        //输出：6

        // 输入：prices = [1,2,3,4,5]
        //输出：4

        // 输入：prices = [7,6,4,3,1]
        //输出：0

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new MaxProfit3().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int buy1 = -prices[0], profit1 = 0;
        int buy2 = -prices[0], profit2 = 0;

        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            profit1 = Math.max(profit1, buy1 + prices[i]);

            buy2 = Math.max(buy2, profit1 - prices[i]);
            profit2 = Math.max(profit2, buy2 + prices[i]);
        }
        return profit2;
    }
}
