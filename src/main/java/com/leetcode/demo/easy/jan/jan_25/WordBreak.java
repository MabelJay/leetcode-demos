package com.leetcode.demo.easy.jan.jan_25;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        // 输入: s = "applepenapple", wordDict = ["apple", "pen"]
        //输出: true

        // 输入: s = "leetcode", wordDict = ["leet", "code"]
        //输出: true

        // : s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        // "aaaaaaa"
        //["aaaa","aaa"]

        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];

        dp[0] = true;
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[len];
    }

    public void printMatrix(boolean[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
