package com.leetcode.demo.sep.day05;

public class IsInterleave {

    public static void main(String[] args) {
        // 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        //输出：true

        //输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
        //输出：false
        String s1 = "aabcc";
        String s2 = "dbbca";
        System.out.println(new IsInterleave().isInterleave2(s1, s2, "aadbbcbcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length()) return false;

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        dp[0][0] = true;
        int i;
        int j;
        for (i = 0; i <= len1; i++) {
            for (j = 0; j <= len2; j++) {
                if (i > 0) {
                    dp[i][j] |= (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
                if (j > 0) {
                    dp[i][j] |= (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[len1][len2];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length()) return false;
        boolean[] dp = new boolean[len2 + 1];
        dp[0] = true;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i > 0) {
                    dp[j] &= s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                if (j > 0) {
                    dp[j] |= (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[len2];
    }
}
