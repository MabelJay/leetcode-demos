package com.leetcode.demo.easy.jan.jan_12;

public class MinPathSum {

    public static void main(String[] args) {
        // 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
        //输出：7
        //解释：因为路径 1→3→1→1→1 的总和最小。

        // 输入：grid = [[1,2,3],[4,5,6]]
        //输出：12

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new MinPathSum().minPathSum(grid));
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = i > 0 ? grid[i][0] + dp[i - 1][0] : grid[i][0];
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = i > 0 ? grid[0][i] + dp[0][i - 1] : grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                } else {
                    dp[j] += grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }

    public void printMatrix(int[][] matrix) {
        int row = matrix.length;
        int queue = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < queue; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
