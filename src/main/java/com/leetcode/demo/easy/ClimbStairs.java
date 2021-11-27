package com.leetcode.demo.easy;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new ClimbStairs().climbStairs2(n));
    }

    public int climbStairs(int n) {
        if (n < 3) return n;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if (n < 3) return n;
        int last = 2;
        int nextToLast = 1;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = last + nextToLast;
            nextToLast = last;
            last = temp;
        }
        return last;
    }
}
