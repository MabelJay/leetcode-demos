package com.leetcode.demo.nov.day16;

public class LongestValidParentheses {

    public static void main(String[] args) {
        // 输入：s = "(()"
        //输出：2

        // 输入：s = ")()())"
        //输出：4

        String s = ")()())";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        int[] dp = new int[len];
        int res = 0;
        int pre;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                pre = i - 1 - dp[i - 1];
                if (pre >= 0 && s.charAt(pre) == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
