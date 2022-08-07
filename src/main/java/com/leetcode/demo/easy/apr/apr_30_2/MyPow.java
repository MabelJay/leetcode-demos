package com.leetcode.demo.easy.apr.apr_30_2;

public class MyPow {

    public static void main(String[] args) {
        // 输入：x = 2.10000, n = 3
        //输出：9.26100

        // 输入：x = 2.00000, n = -2
        //输出：0.25000
        //解释：2-2 = 1/22 = 1/4 = 0.25

        // 输入：x = 2.00000, n = 10
        //输出：1024.00000

        System.out.println(new MyPow().myPow(2.0000, 10));
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0 || x == 1) return 1;

        long count = n;
        if (n < 0) {
            count = -count;
        }
        double res = 1;
        double tempNum = x;
        while (count != 0) {
            if ((count & 1) != 0) {
                res *= tempNum;
            }
            tempNum *= tempNum;
            count >>= 1;
        }
        return n < 0 ? (1 / res) : res;
    }
}
