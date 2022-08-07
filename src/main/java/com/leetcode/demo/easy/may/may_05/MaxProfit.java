package com.leetcode.demo.easy.may.may_05;

public class MaxProfit {

    public static void main(String[] args) {
        // 输入：prices = [7,1,5,3,6,4]
        //输出：7

        // 输入：prices = [1,2,3,4,5]
        //输出：4

        // 输入：prices = [7,6,4,3,1]
        //输出：0

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfit().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }
}
