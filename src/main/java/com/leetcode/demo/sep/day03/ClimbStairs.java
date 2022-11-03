package com.leetcode.demo.sep.day03;

public class ClimbStairs {
    public static void main(String[] args) {
        // 输入：n = 3
        //输出：3

        System.out.println(new ClimbStairs().climbStairs(3));
    }

    public int climbStairs(int n) {
        int first = 1;
        int second = 1;

        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return second;
    }
}
