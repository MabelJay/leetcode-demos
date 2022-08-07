package com.leetcode.demo.easy.jan.jan_12;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        // 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        //输出：2

        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        // 输入：obstacleGrid = [[0,1],[0,0]]
        //输出：1

        int[][] obstacleGrid2 = {{0, 1}, {0, 0}};

        // [[1,0]]
        int[][] obstacleGrid3 = {{1, 0}};
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles2(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = i > 0 ? dp[i - 1][0] : 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = i > 0 ? dp[0][i - 1] : 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] res = new int[n];

        res[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                    continue;
                }

                if (j >= 1) {
                    res[j] += res[j - 1];
                }
            }
        }
        return res[n - 1];
    }
}
