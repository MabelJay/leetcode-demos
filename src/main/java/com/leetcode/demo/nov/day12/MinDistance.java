package com.leetcode.demo.nov.day12;

public class MinDistance {

    public static void main(String[] args) {
        // 输入: word1 = "sea", word2 = "eat"
        //输出: 2
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(new MinDistance().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) return 0;

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return len1 + len2 - dp[len1][len2] * 2;
    }
}
