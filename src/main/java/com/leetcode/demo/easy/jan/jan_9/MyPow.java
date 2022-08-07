package com.leetcode.demo.easy.jan.jan_9;

public class MyPow {
    public static void main(String[] args) {
        //输入：x = 2.00000, n = 10
        //输出：1024.00000

        // 2.00000
        //-2147483648

        double x = -1;
        int n = -2147483648;
        System.out.println(Long.toBinaryString(2147483648l));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new MyPow().myPow(x, n));
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (x == 1 || n == 0) return 1;
        long powCount = n;
        if (n < 0) {
            powCount = -powCount;
        }

        double res = 1;
        double val = x;
        while (powCount != 0) {
            if ((powCount & 1) != 0) {
                res *= val;
            }
            val *= val;
            powCount >>= 1;
        }
        return n > 0 ? res : (1 / res);
    }
}
