package com.leetcode.demo.apr.day22;

import java.util.Arrays;

public class IsInterleave {

    public static void main(String[] args) {
        // 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        //输出：true

        // 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
        //输出：false

        // test: s1 = aabcc
        //s2  = dbbca
        //s3 = aadbbcbcac
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(new IsInterleave().isInterleave2(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) return s2.equals(s3);
        if (s2 == null || s2.length() == 0) return s1.equals(s3);
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if ((len1 + len2) != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int index = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(index));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(index));
                }
            }
        }
        return dp[len1][len2];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) return s2.equals(s3);
        if (s2 == null || s2.length() == 0) return s1.equals(s3);

        int len1 = s1.length();
        int len2 = s2.length();
        if ((len1 + len2) != s3.length()) return false;

        boolean[] dp = new boolean[len2 + 1];
        dp[0] = true;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int index = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(index);
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(index));
                }
            }
        }
        return dp[len2];
    }

    private boolean canConstruct(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) return s2.equals(s3);
        if (s2 == null || s2.length() == 0) return s1.equals(s3);
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if ((len1 + len2) != len3) return false;

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        while (true) {
            if (index1 < len1 && s1.charAt(index1) == s3.charAt(index3)) {
                while (index1 < len1 && s1.charAt(index1) == s3.charAt(index3)) {
                    index1++;
                    index3++;
                }
            } else if (index2 < len2 && s2.charAt(index2) == s3.charAt(index3)) {
                while (index2 < len2 && s2.charAt(index2) == s3.charAt(index3)) {
                    index2++;
                    index3++;
                }
            } else return false;
            if (index1 == len1 && index2 == len2) return true;
        }
    }
}
