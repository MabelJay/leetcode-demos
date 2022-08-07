package com.leetcode.demo.easy.may.may_26;

import java.util.Arrays;

public class IsMatch {

    public static void main(String[] args) {
        // s = "aab"
        //p = "c*a*b"
        //输出: true

        String s = "aa";
        String p = "a*";
        System.out.println(new IsMatch().isMatch(s, p));
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
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (isMatch(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m][n];
    }

    public boolean isMatch(String s, String p, int index1, int index2) {
        if (index1 == 0) return false;
        else if (p.charAt(index2 - 1) == '.') return true;
        return s.charAt(index1 - 1) == p.charAt(index2 - 1);
    }
}
