package com.leetcode.demo.easy.may.may_12;

public class SubSeqCount {

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};

        String s2 = "dsahjpjauf";
        String[] words2 = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        System.out.println(new SubSeqCount().getSubSeqCount(s, words));
        System.out.println(new SubSeqCount().getSubSeqCount(s2, words2));

        System.out.println(new SubSeqCount().isSubsequence2("abc", "abcde"));
    }

    public int getSubSeqCount(String s, String[] words) {
        int len1 = s.length();

        int count = 0;
        for (String word : words) {
            int index = 0;
            for (int i = 0; i < len1; i++) {
                if (s.charAt(i) == word.charAt(index)) {
                    index++;
                }
                if (index == word.length()) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i)) index++;
            if (index == s.length()) return true;
        }
        return false;
    }

    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;

        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n] == s.length();
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
