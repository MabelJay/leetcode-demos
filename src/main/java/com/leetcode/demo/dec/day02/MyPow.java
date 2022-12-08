package com.leetcode.demo.dec.day02;

public class MyPow {

    public static void main(String[] args) {
        // 输入：x = 2.00000, n = 10
        //输出：1024.00000

        // 输入：x = 2.00000, n = -2
        //输出：0.25000
        double x = 2.0;
        int n = -10;
        System.out.println(new MyPow().myPow(x, -n));
    }

    public double myPow(double x, int n) {
        if (x == 0 && n < 0) return 0;
        long exp = n;
        if (n < 0) exp = -exp;

        double res = calPow(x, exp);
        if (n < 0) return 1 / res;
        return res;
    }

    public double calPow(double base, long exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;

        double res = calPow(base, exp >> 1);
        res *= res;
        if ((exp & 1) == 1) res *= base;
        return res;
    }
}
