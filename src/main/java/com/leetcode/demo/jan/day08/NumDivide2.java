package com.leetcode.demo.jan.day08;

public class NumDivide2 {
    public static void main(String[] args) {
        // 输入: dividend = 10, divisor = 3
        //输出: 3

        // 输入: dividend = 7, divisor = -3
        //输出: -2
        System.out.println(new NumDivide2().divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new RuntimeException("divisor is zero");
        }
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

        if (dividend == Integer.MIN_VALUE) {
            int res = div(add(dividend, 1), divisor);
            return add(res, div(minus(dividend, multiply(res, divisor)), divisor));
        }
        return div(dividend, divisor);
    }

    public int div(int a, int b) {
        int x = isNeg(a) ? getNeg(a) : a;
        int y = isNeg(b) ? getNeg(b) : b;

        int res = 0;
        for (int i = 31; i > -1; i--) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? getNeg(res) : res;
    }

    public boolean isNeg(int num) {
        return num < 0;
    }

    public int getNeg(int num) {
        return (~num) + 1;
    }

    public int minus(int a, int b) {
        return add(a, getNeg(b));
    }

    public int add(int num1, int num2) {
        int sum = num1;
        while (num2 != 0) {
            sum = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return sum;
    }

    public int multiply(int A, int B) {
        if (A == 0 || B == 0) return 0;
        int res = 0;
        while (B != 0) {
            if ((B & 1) != 0) {
                res = add(res, A);
            }
            A <<= 1;
            B >>>= 1;
        }
        return res;
    }
}
