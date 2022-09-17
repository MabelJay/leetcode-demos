package com.leetcode.demo.sep_17;

public class IsInterleave {

    public static void main(String[] args) {
        // 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        //输出：true
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcad";
        System.out.println(new IsInterleave().isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) return s2.equals(s3);
        if (s2 == null || s2.length() == 0) return s1.equals(s3);
        int m = s1.length();
        int n = s2.length();
        int t = s3.length();
        if (t != m + n) return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int index = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(index));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(index));
                }
            }
        }
        return dp[m][n];
    }
}
