package com.leetcode.demo.easy.apr.apr_25;

import java.util.Arrays;
import java.util.Map;

public class NthUglyNumber {

    public static void main(String[] args) {
        // 输入：n = 10
        //输出：12
        //解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
        System.out.println(new NthUglyNumber().nthUglyNumber(11));
    }

    public int nthUglyNumber(int n) {
        if (n < 6) return n;

        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = 2 * dp[p2];
            int num3 = 3 * dp[p3];
            int num5 = 5 * dp[p5];
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) p2++;
            if (dp[i] == num3) p3++;
            if (dp[i] == num5) p5++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}
