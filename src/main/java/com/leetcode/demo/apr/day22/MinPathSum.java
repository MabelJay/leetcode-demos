package com.leetcode.demo.apr.day22;

import java.util.Arrays;

public class MinPathSum {

    public static void main(String[] args) {
        // 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
        //输出：7

        // 输入：grid = [[1,2,3],[4,5,6]]
        //输出：12

        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(new MinPathSum().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int columns = grid[0].length;

        int[] dp = new int[columns];
        dp[0] = grid[0][0];
        for (int i = 1; i < columns; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == 0) {
                    dp[j] += grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[columns - 1];
    }
}
