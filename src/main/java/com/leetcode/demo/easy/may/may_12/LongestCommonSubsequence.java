package com.leetcode.demo.easy.may.may_12;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        // 输入：text1 = "abcde", text2 = "ace"
        //输出：3

        // 输入：text1 = "abc", text2 = "abc"
        //输出：3

        // 输入：text1 = "abc", text2 = "def"
        //输出：0

        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        printMatrix(dp);
        return dp[m][n];
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
