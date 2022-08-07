package com.leetcode.demo.easy.apr.apr_29;

public class ClimbStairs {

    public static void main(String[] args) {
        // 输入：n = 2
        //输出：2

        // 输入：n = 3
        //输出：3

        System.out.println(new ClimbStairs().climbStairs(5));
        System.out.println(new ClimbStairs().climbStairs2(5));
        System.out.println(new ClimbStairs().climbStairs3(5));
    }

    public int climbStairs(int n) {
        if (n < 3) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if (n < 3) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int climbStairs3(int n) {
        if (n < 3) return n;
        int num1 = 1;
        int num2 = 2;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans = num1 + num2;
            num1 = num2;
            num2 = ans;
        }
        return ans;
    }

    //  if (n < 3) return n;
    //        int last = 2;
    //        int nextToLast = 1;
    //        int temp;
    //        for (int i = 3; i <= n; i++) {
    //            temp = last + nextToLast;
    //            nextToLast = last;
    //            last = temp;
    //        }
    //        return last;
    //    }
}
