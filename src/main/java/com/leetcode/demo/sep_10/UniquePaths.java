package com.leetcode.demo.sep_10;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        // 输入：m = 3, n = 7
        //输出：28

        // 输入：m = 3, n = 2
        //输出：3

        System.out.println(new UniquePaths().uniquePaths(19, 13));
        System.out.println(new UniquePaths().uniquePaths2(19, 13));
    }

    public int uniquePaths(int m, int n) {
        return dfs(m, n, 0, 0);
    }

    public int dfs(int m, int n, int row, int column) {
        if (row == m - 1 && column == n - 1) return 1;
        if (row >= m) return 0;
        if (column >= n) return 0;

        return dfs(m, n, row + 1, column) + dfs(m, n, row, column + 1);
    }

    public int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
