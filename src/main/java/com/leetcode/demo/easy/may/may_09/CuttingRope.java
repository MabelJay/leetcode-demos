package com.leetcode.demo.easy.may.may_09;

public class CuttingRope {

    public static void main(String[] args) {
        // 输入: 2
        //输出: 1
        //解释: 2 = 1 + 1, 1 × 1 = 1

        // 输入: 10
        //输出: 36
        //解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

        System.out.println(new CuttingRope().cuttingRope3(10));
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public int cuttingRope3(int n) {
        if (n < 4) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
