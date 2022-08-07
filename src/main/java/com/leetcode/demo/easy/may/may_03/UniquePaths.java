package com.leetcode.demo.easy.may.may_03;

public class UniquePaths {

    public static void main(String[] args) {
        // 输入：m = 3, n = 7
        //输出：28

        //输入：m = 3, n = 3
        //输出：6

        System.out.println(new UniquePaths().uniquePaths(19, 13));
        System.out.println(new UniquePaths().uniquePaths2(19, 13));
    }

    public int uniquePaths(int m, int n) {
        return countPath(m, n, 0, 0);
    }

    public int countPath(int m, int n, int x, int y) {
        if (x >= m || y >= n) return 0;
        if (x == m - 1 && y == n - 1) return 1;

        return countPath(m, n, x + 1, y) + countPath(m, n, x, y + 1);
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
