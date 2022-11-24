package com.leetcode.demo.nov.day16;

public class IsMatchRegex {

    public static void main(String[] args) {
        // 输入：s = "aa", p = "a"
        //输出：false

        // 输入：s = "aa", p = "a*"
        //输出：true
        String s = "aa";
        System.out.println(new IsMatchRegex().isMatch(s, "a*"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (isMatch(s, p, i, j - 1)) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else {
                    if (isMatch(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatch(String s, String p, int i, int j) {
        if (i == 0) return false;
        return p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1);
    }
}
