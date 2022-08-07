package com.leetcode.demo.easy.may.may_08;

public class MyPow {
    public static void main(String[] args) {
        // 输入：x = 2.00000, n = 10
        //输出：1024.00000

        // 输入：x = 2.10000, n = 3
        //输出：9.26100

        // 输入：x = 2.00000, n = -2
        //输出：0.25000
        //解释：2-2 = 1/22 = 1/4 = 0.25

        // 2.00000
        //-2147483648

        System.out.println(Integer.MIN_VALUE < 0);
        System.out.println(Integer.MIN_VALUE > -2147483648);
        System.out.println(new MyPow().myPow(2.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        if (x == 1 || x == 0) return x;
        if (n == 0) return 1;

        long pow = n;
        if (n < 0) {
            pow = -pow;
        }

        double res = 1;
        while (pow != 0) {
            if ((pow & 1) != 0) {
                res *= x;
            }
            x *= x;
            pow >>= 1;
        }
        return n < 0 ? 1 / res : res;
    }
}
