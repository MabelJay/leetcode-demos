package com.leetcode.demo.easy.may.may_14;

import java.util.Arrays;

public class MaxValueOfGifts {

    int maxProfit;
    int[][] directions = {{0, 1}, {1, 0}};

    public static void main(String[] args) {
        // 输入:
        //  [1,3,1],
        //  [1,5,1],
        //  [4,2,1]
        //输出: 12


        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        // [[1,2,5],[3,2,1]]
        System.out.println(new MaxValueOfGifts().maxValue3(grid));
    }

    public int maxValue(int[][] grid) {
        maxProfit = 0;
        dfs(grid, 0, 0, 0);
        return maxProfit;
    }

    public int maxValue2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        printMatrix(dp);
        return dp[m][n];
    }

    public int maxValue3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i - 1][j - 1];
            }
        }
        return dp[n];
    }


    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int[][] grid, int rowIndex, int columnIndex, int preProfit) {

        preProfit += grid[rowIndex][columnIndex];
        maxProfit = Math.max(maxProfit, preProfit);
        int temp = grid[rowIndex][columnIndex];

        for (int[] direction : directions) {
            int nx = rowIndex + direction[0];
            int ny = columnIndex + direction[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                dfs(grid, nx, ny, preProfit);
            }
        }
        grid[rowIndex][columnIndex] = temp;
    }
}
