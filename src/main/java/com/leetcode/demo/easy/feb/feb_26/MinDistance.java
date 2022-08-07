package com.leetcode.demo.easy.feb.feb_26;

import java.util.*;

public class MinDistance {
    public static void main(String[] args) {
        // 输入: word1 = "sea", word2 = "eat"
        //输出: 2

        String word1 = "sea";
        String word2 = "eat";
        String word3 = "leetcode";
        String word4 = "ecto";

        // "sea"
        //"ate"
        // 4

        // "abcdxabcde"
        //"abcdeabcdx"
        // 4
        String word5 = "abcdxabcde";
        String word6 = "abcdeabcdx";
        System.out.println(new MinDistance().minDistance2(word5, word6));
    }

    public int minDistance2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (word1.contains(word2)) return len1 - len2;
        if (word2.contains(word1)) return len2 - len1;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int maxCommon = dp[len1][len2];
        return len1 + len2 - 2 * maxCommon;
    }

    public void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (word1.contains(word2)) return len1 - len2;
        if (word2.contains(word1)) return len2 - len1;

        int[] dp = new int[len2 + 1];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i <= len2; i++) {
            char temp = word2.charAt(i - 1);
            if (word1.indexOf(temp) > -1) {
                int tmpMax = 1;
                for (int j = 1; j < i; j++) {
                    int index = word1.indexOf(word2.charAt(j - 1));
                    if (dp[j] > 0 && index != -1) {
                        String tmpStr = word1.substring(dp[j]);
                        if (tmpStr.indexOf(temp) > -1) {
                            dp[i] = dp[j] + 1;
                            tmpMax = Math.max(tmpMax, dp[i]);
                        }
                    } else {
                        dp[i] = 1;
                    }
                }
                dp[i] = tmpMax;
            } else {
                dp[i] = dp[i - 1];
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        return len1 + len2 - 2 * max;
    }
}
