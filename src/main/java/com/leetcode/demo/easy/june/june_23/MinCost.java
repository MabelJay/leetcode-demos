package com.leetcode.demo.easy.june.june_23;

import java.util.Arrays;

public class MinCost {

    public static void main(String[] args) {
        // 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
        //输出: 10

        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(new MinCost().minCost(costs));
    }

    public int minCost(int[][] costs) {
        int m = costs.length;

        int[] dp = new int[3];
        System.arraycopy(costs[0], 0, dp, 0, 3);

        for (int i = 1; i < m; i++) {
            int[] tmpArr = Arrays.copyOf(dp, 3);
            dp[0] = Math.min(tmpArr[1], tmpArr[2]) + costs[i][0];
            dp[1] = Math.min(tmpArr[0], tmpArr[2]) + costs[i][1];
            dp[2] = Math.min(tmpArr[1], tmpArr[0]) + costs[i][2];
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
