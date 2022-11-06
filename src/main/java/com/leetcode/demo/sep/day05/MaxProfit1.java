package com.leetcode.demo.sep.day05;

public class MaxProfit1 {

    public static void main(String[] args) {
        // 输入：[7,1,5,3,6,4]
        //输出：5
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfit1().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
}
