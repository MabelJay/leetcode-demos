package com.leetcode.demo.easy.feb.feb_12;

import java.util.Arrays;

public class FibDemo {

    public static void main(String[] args) {
        // 1 1 2 3 5
        // 1134903170
        // 134903163
        // 1000000007
        System.out.println(new FibDemo().fib(48));
//        System.out.println(new FibDemo().fib2(48));
        System.out.println(new FibDemo().fib3(48));
        System.out.println(new FibDemo().fib4(48));

    }

    public int fib(int n) {
        if (n < 2) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public int fib4(int n) {
        if (n < 2) return n;

        int first = 0, second = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = (first + second) % 1000000007;
            first = second;
            second = res;
        }
        return res;
    }

    public int fib2(int n) {
        if (n < 2) return n;
        return fib2(n - 1) + fib2(n - 2);
    }

    public int fib3(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
}

