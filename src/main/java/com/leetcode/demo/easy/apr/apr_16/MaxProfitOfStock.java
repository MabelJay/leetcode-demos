package com.leetcode.demo.easy.apr.apr_16;

public class MaxProfitOfStock {

    public static void main(String[] args) {
        // 输入：[7,1,5,3,6,4]
        //输出：5

        // 输入：prices = [7,6,4,3,1]
        //输出：0

        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(new MaxProfitOfStock().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            } else minPrice = prices[i];
        }
        return maxProfit;
    }

    // if (prices == null || prices.length < 2) return 0;
    //        int minPrice = prices[0];
    //        int minProfit = 0;
    //
    //        for (int i = 1; i < prices.length; i++) {
    //            if (prices[i] < minPrice) {
    //                minPrice = prices[i];
    //            } else if (minProfit < (prices[i] - minPrice)) {
    //                minProfit = prices[i] - minPrice;
    //            }
    //        }
    //        return minProfit;
}
