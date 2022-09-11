package com.leetcode.demo.sep_11;

import java.util.Arrays;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        // 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        //输出：2

        int[][] grid = {{0, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};

        int[][] grid2 = {{1, 0}};

        // [0,0,0],[0,1,0],[0,0,0]
        int[][] grid3 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        // [[0,1,0,0,0],[1,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles3(grid3));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return dfs(obstacleGrid, 0, 0);
    }

    public int dfs(int[][] obstacleGrid, int row, int column) {
        if (row == obstacleGrid.length - 1 && column == obstacleGrid[0].length) return 1;
        if (row >= obstacleGrid.length || column >= obstacleGrid[0].length) return 0;

        if (obstacleGrid[row][column] != 1) {
            return dfs(obstacleGrid, row + 1, column) + dfs(obstacleGrid, row, column + 1);
        }
        return 0;
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            if (i > 0 && obstacleGrid[i][0] != 1) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < columns; i++) {
            if (obstacleGrid[0][i] != 1 && obstacleGrid[0][i - 1] != 1) {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[rows - 1][columns - 1];
    }

    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int columns = obstacleGrid[0].length;

        int[] dp = new int[columns];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < columns; j++) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                    continue;
                }

                if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[columns - 1];
    }

    public void printMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
