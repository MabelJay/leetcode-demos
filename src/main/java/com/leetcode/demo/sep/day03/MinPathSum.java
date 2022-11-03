package com.leetcode.demo.sep.day03;

import java.util.Arrays;

public class MinPathSum {

    public static void main(String[] args) {
        // 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
        //输出：7

        //输入：grid = [[1,2,3],[4,5,6]]
        //输出：12

        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(new MinPathSum().minPathSum2(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j > 0) {
                        dp[j] = dp[j - 1] + grid[i][j];
                    }
                } else if (j > 0) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                } else dp[j] += grid[i][j];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n - 1];
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
