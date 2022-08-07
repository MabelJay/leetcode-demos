package com.leetcode.demo.easy.mar.mar_01;

public class MaxScoreSightseeingPair {

    public static void main(String[] args) {
        // 输入：values = [8,1,5,2,6]
        //输出：11

        int[] values = {8, 1, 5, 2, 6};
        System.out.println(new MaxScoreSightseeingPair().maxScoreSightseeingPair(values));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, max = values[0];
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return ans;
    }
}
