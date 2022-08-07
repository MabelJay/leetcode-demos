package com.leetcode.demo.easy.feb.feb_12;

public class MaxProfitHard {

    public static void main(String[] args) {
        // 输入：prices = [3,3,5,0,0,3,1,4]
        //输出：6
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        int[] prices2 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};

        // [2,1,4,5,2,9,7]
        // 11

        // [1,2,4,2,5,7,2,4,9,0]
        // 13
        System.out.println(new MaxProfitHard().maxProfit(prices2));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
