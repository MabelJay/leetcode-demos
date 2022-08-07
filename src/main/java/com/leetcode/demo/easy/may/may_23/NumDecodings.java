package com.leetcode.demo.easy.may.may_23;

public class NumDecodings {
    public static void main(String[] args) {
        // 输入：s = "12"
        //输出：2

        System.out.println(new NumDecodings().numDecodings2("06"));
        System.out.println(new NumDecodings().numDecodings("06"));
    }

    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    public int numDecodings2(String s) {
        int num1 = 1;
        int res = 0;
        int num2 = 0;
        for (int i = 1; i <= s.length(); i++) {
            res = 0;
            if (s.charAt(i - 1) != '0') {
                res += num1;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0') <= 26) {
                res += num2;
            }
            num2 = num1;
            num1 = res;
        }
        return res;
    }
}
