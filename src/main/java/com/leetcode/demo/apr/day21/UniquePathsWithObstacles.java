package com.leetcode.demo.apr.day21;

import java.util.Arrays;

public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        // 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        //输出：2

        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid2 = {{0, 1}, {0, 0}};
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles2(obstacleGrid2));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;

        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int j = 1; j < columns; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rows - 1][columns - 1];
    }

    private void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;

        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;

        int[] dp = new int[columns];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < columns; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[i] = dp[i - 1];
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (j > 0) {
                        dp[j] += dp[j - 1];
                    }
                } else {
                    dp[j] = 0;
                }
            }
        }
        return dp[columns - 1];
    }
}
