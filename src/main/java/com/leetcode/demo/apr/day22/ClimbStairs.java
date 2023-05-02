package com.leetcode.demo.apr.day22;

public class ClimbStairs {

    public static void main(String[] args) {
        // 输入：n = 2
        //输出：2

        // 输入：n = 3
        //输出：3
        System.out.println(new ClimbStairs().climbStairs2(5));
    }

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int climbStairs2(int n) {
        if (n <= 2) return n;

        int first = 1;
        int second = 2;

        for (int i = 2; i < n; i++) {
            int cur = first + second;
            first = second;
            second = cur;
        }
        return second;
    }
}
