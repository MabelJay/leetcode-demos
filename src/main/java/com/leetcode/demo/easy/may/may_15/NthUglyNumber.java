package com.leetcode.demo.easy.may.may_15;

public class NthUglyNumber {

    public static void main(String[] args) {
        // 输入: n = 10
        //输出: 12
        //解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

        System.out.println(new NthUglyNumber().nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        if (n < 2) return n;

        int count = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        while (count < n) {
            int num2 = 2 * dp[p2];
            int num3 = 3 * dp[p3];
            int num5 = 5 * dp[p5];
            dp[count] = Math.min(num2, Math.min(num3, num5));
            if (dp[count] == num2) p2++;
            if (dp[count] == num3) p3++;
            if (dp[count] == num5) p5++;
            count++;
        }
        return dp[n - 1];
    }
}
