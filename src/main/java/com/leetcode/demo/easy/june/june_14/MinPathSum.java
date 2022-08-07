package com.leetcode.demo.easy.june.june_14;

import java.util.Arrays;

public class MinPathSum {

    int minSum;

    public static void main(String[] args) {
        // 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
        //输出：7

        // 输入：grid = [[1,2,3],[4,5,6]]
        //输出：12
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(new MinPathSum().minPathSum3(grid2));
    }

    public int minPathSum(int[][] grid) {
        minSum = Integer.MAX_VALUE;
        dfs(grid, 0, 0, 0);
        return minSum;
    }

    public void dfs(int[][] grid, int row, int column, int sum) {
        if (row == grid.length - 1 && column == grid[0].length - 1) {
            minSum = Math.min(minSum, sum + grid[row][column]);
            return;
        }
        if (row < 0 || column < 0 || row == grid.length || column == grid[0].length) return;
        dfs(grid, row + 1, column, sum + grid[row][column]);
        dfs(grid, row, column + 1, sum + grid[row][column]);
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j > 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minPathSum3(int[][] grid) {
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }

    public void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
