package com.leetcode.demo.easy;

public class MaxProfit {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};
        // [2,4,1]

//        int[] prices = {2, 4, 1};
        System.out.println(new MaxProfit().maxProfit2(prices));
    }

    // O(n*n)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int val = prices[j] - prices[i];
                if (val > maxProfit) {
                    maxProfit = val;
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minPrice = prices[0];
        int minProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (minProfit < (prices[i] - minPrice)) {
                minProfit = prices[i] - minPrice;
            }
        }
        return minProfit;
    }
}
