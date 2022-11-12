package com.leetcode.demo.nov.day12;

public class NthUglyNumber {

    public static void main(String[] args) {
        // 输入：n = 10
        //输出：12
        System.out.println(new NthUglyNumber().nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        if (n <= 6) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;

        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;

            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) p2++;
            if (dp[i] == num3) p3++;
            if (dp[i] == num5) p5++;
        }
        return dp[n];
    }
}
