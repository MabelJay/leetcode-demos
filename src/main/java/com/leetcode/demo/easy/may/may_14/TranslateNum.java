package com.leetcode.demo.easy.may.may_14;

import java.util.Arrays;

public class TranslateNum {

    public static void main(String[] args) {
        // 输入: 12258
        //输出: 5
        int num = 12258;
        System.out.println(new TranslateNum().translateNum(num));
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = num % 10;
            num = num / 10;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < n; i++) {
            if (res[i - 1] == 0) {
                dp[i + 1] = dp[i];
            } else {
                if (res[i - 1] * 10 + res[i] < 26) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else dp[i + 1] = dp[i];
            }
        }
        return dp[n];
    }
}
