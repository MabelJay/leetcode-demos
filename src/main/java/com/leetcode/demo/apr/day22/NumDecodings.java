package com.leetcode.demo.apr.day22;

public class NumDecodings {

    public static void main(String[] args) {
        // 输入：s = "226"
        //输出：3

        // 输入：s = "12"
        //输出：2

        // 输入：s = "06"
        //输出：0

//        System.out.println('A' - 64);
        System.out.println(new NumDecodings().numDecodings("026"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        int[] dp = new int[len + 1];

        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
