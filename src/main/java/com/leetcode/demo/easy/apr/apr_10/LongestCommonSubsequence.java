package com.leetcode.demo.easy.apr.apr_10;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        // 输入：text1 = "abcde", text2 = "ace"
        //输出：3

        // 输入：text1 = "abc", text2 = "def"
        //输出：0
        //解释：两个字符串没有公共子序列，返回 0 。

        String text1 = "abcba";
        String text2 = "abcbcba";

        // "psnw"
        //"vozsh"

        // "abcba"
        //"abcbcba"
        // 5
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // int len1 = text1.length();
    //        int len2 = text2.length();
    //
    //        int[][] dp = new int[len1 + 1][len2 + 1];
    //        for (int i = 1; i <= len1; i++) {
    //            for (int j = 1; j <= len2; j++) {
    //                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
    //                    dp[i][j] = dp[i - 1][j - 1] + 1;
    //                } else {
    //                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    //                }
    //            }
    //        }
    //        return dp[len1][len2];
}
