package com.leetcode.demo.apr.day19;

public class LongestPalindrome {

    public static void main(String[] args) {
        // 输入：s = "babad"
        //输出："bab"
        //解释："aba" 同样是符合题意的答案。

        String s = "cbbd";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int beginIndex = 0;
        char[] arr = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i - 1;
                if (j > len - 1) break;

                if (arr[i] != arr[j]) dp[i][j] = false;
                else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && L > maxLen) {
                    beginIndex = i;
                    maxLen = L;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLen);
    }
}
