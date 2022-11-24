package com.leetcode.demo.nov.day24;

public class MyPow {
    public static void main(String[] args) {
        // 输入：x = 2.10000, n = 3
        //输出：9.26100

        // 输入：x = 2.00000, n = -2
        //输出：0.25000

        double x = 2.0;
        System.out.println(new MyPow().myPow(x, -2));
    }

    public double myPow(double x, int n) {
        if (x == 0 && n < 0) return 0;

        long exponent = n;
        if (n < 0) exponent = (-1) * exponent;

        double res = getPow(x, exponent);
        if (n < 0) {
            res = 1.0 / res;
        }
        return res;
    }

    public double getPow(double base, long exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double res = getPow(base, exponent >> 1);
        res *= res;
        if ((exponent & 1) == 1) {
            res *= base;
        }
        return res;
    }
}
