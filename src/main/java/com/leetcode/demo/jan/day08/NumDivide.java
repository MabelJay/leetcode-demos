package com.leetcode.demo.jan.day08;

public class NumDivide {

    public static void main(String[] args) {
        // 输入: dividend = 10, divisor = 3
        //输出: 3

        // 输入: dividend = 7, divisor = -3
        //输出: -2
        System.out.println(-2147483648 == Integer.MIN_VALUE);
        System.out.println(new NumDivide().divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return Integer.MIN_VALUE;

            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        int x = isNeg(dividend) ? getNeg(dividend) : dividend;
        int y = isNeg(divisor) ? getNeg(divisor) : divisor;

        int count = 0;
        while (x >= y) {
            count++;
            boolean flag = false;
            int num2 = y;
            while (x > num2) {
                num2 <<= 1;
                count <<= 1;
                flag = true;
            }

            if (flag) {
                num2 >>= 1;
                count >>= 1;
            }
            x -= num2;
        }
        return isNeg(dividend) ^ isNeg(divisor) ? getNeg(count) : count;
    }

    public boolean isNeg(int num) {
        return num < 0;
    }

    public int getNeg(int num) {
        return (~num) + 1;
    }
}
