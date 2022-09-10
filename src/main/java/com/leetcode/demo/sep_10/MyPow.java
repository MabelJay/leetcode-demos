package com.leetcode.demo.sep_10;

public class MyPow {
    public static void main(String[] args) {
        //输入：x = 2.00000, n = 10
        //输出：1024.00000

        // 输入：x = 2.10000, n = 3
        //输出：9.26100
        double x = 2.0;
        System.out.println(new MyPow().myPow(x, 10));
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? pow(x, N) : 1.0 / pow(x, -N);
    }

    public double pow(double x, long n) {
        if (n == 0) return 1.0;
        double res = pow(x, n / 2);
        return n % 2 == 0 ? res * res : res * res * x;
    }

    public double pow2(double x, long n) {
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
