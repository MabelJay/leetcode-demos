package com.leetcode.demo.sep_11;

public class ClimbStairs {

    public static void main(String[] args) {
        // 输入：n = 2
        //输出：2

        // 3  3
        System.out.println(new ClimbStairs().climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int first = 1;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            int res = first + second;
            first = second;
            second = res;
        }
        return second;
    }
}
