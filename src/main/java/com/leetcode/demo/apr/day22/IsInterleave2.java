package com.leetcode.demo.apr.day22;

import java.util.Objects;

public class IsInterleave2 {

    public static void main(String[] args) {
        // 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        //输出：true

        // 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
        //输出：false
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(new IsInterleave2().isInterleave2(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) return Objects.equals(s2, s3);
        if (s2 == null || s2.length() == 0) return Objects.equals(s1, s3);

        int len1 = s1.length();
        int len2 = s2.length();
        if ((len1 + len2) != s3.length()) return false;

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int index = i + j - 1;
                if (i > 0) {
                    dp[i][j] = s3.charAt(index) == s1.charAt(i - 1) && dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] |= s3.charAt(index) == s2.charAt(j - 1) && dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) return Objects.equals(s2, s3);
        if (s2 == null || s2.length() == 0) return Objects.equals(s1, s3);

        int len1 = s1.length();
        int len2 = s2.length();
        if ((len1 + len2) != s3.length()) return false;

        boolean[] dp = new boolean[len2 + 1];
        dp[0] = true;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int index = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && s3.charAt(index) == s1.charAt(i - 1);
                }
                if (j > 0) {
                    dp[j] |= s3.charAt(index) == s2.charAt(j - 1) && dp[j - 1];
                }
            }
        }
        return dp[len2];
    }
}
