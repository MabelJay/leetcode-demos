package com.leetcode.demo.easy.june.june_20;

import java.util.Arrays;

public class UniquePaths {

    int count = 0;

    public static void main(String[] args) {
        // 输入：m = 3, n = 7
        //输出：28
        System.out.println(new UniquePaths().uniquePaths3(3, 3));
    }

    public int uniquePaths(int m, int n) {
        dfs(m, n, 0, 0);
        return count;
    }

    public void dfs(int m, int n, int rIndex, int cIndex) {
        if (rIndex == m - 1 && cIndex == n - 1) {
            count++;
            return;
        }

        if (rIndex >= m || cIndex >= n) return;

        dfs(m, n, rIndex + 1, cIndex);
        dfs(m, n, rIndex, cIndex + 1);
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

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
