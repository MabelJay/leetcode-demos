package com.leetcode.demo.sep.day02;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        // 输入：m = 3, n = 7
        //输出：28
        System.out.println(new UniquePaths().uniquePaths3(3, 7));
    }

    public int uniquePaths(int m, int n) {
        return dfs(m, n, 0, 0);
    }

    public int dfs(int m, int n, int row, int column) {
        if (row >= m || column >= n) return 0;
        if (row == m - 1 && column == n - 1) return 1;
        return dfs(m, n, row + 1, column) + dfs(m, n, row, column + 1);
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int uniquePaths3(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
