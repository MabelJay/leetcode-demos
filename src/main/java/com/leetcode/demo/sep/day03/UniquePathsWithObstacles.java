package com.leetcode.demo.sep.day03;

import java.util.Arrays;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        // 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        //输出：2

        // [[0,1,0,0,0},[1,0,0,0,0},[0,0,0,0,0},[0,0,0,0,0}}
        //0

        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles2(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;

        int[][] dp = new int[rows][columns];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < columns; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = dp[0][i - 1];
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

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int columns = obstacleGrid[0].length;

        int[] dp = new int[columns];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < columns; j++) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j > 0 && ints[j - 1] != 1) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[columns - 1];
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
