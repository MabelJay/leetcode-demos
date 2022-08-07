package com.leetcode.demo.easy.jan.jan_11;

public class UniquePaths {

    public static void main(String[] args) {
        // 输入：m = 3, n = 7
        //输出：28

        //51
        //9
        System.out.println(new UniquePaths().uniquePaths3(51, 9));
    }

    public int uniquePaths2(int m, int n) {
        if (m == 0) return n - 1;
        if (n == 0) return m - 1;
        if (m == 1 && n == 1) return 1;
        return dfs(m, n, 0, 0);
    }

    public int dfs(int m, int n, int x, int y) {
        if (x == m - 1 && y == n - 1) return 0;
        if (x == m - 1) return 1;
        if (y == n - 1) return 1;

        return dfs(m, n, x + 1, y) + dfs(m, n, x, y + 1);
    }

    // dp
    public int uniquePaths(int m, int n) {
        if (m == 0) return n - 1;
        if (n == 0) return m - 1;
        if (m == 1 && n == 1) return 1;

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

    public int uniquePaths3(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
