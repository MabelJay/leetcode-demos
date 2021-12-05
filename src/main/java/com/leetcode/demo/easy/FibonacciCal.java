package com.leetcode.demo.easy;

public class FibonacciCal {
    public static void main(String[] args) {
        //F(0) = 0，F(1) = 1
        //F(n) = F(n - 1) + F(n - 2)，其中 n > 1
        System.out.println(new FibonacciCal().fib2(2));
    }

    public int fib(int n) {
        if (n < 2) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {
        if (n < 2) return n;
        int pre = 1, lastToPre = 0;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = lastToPre + pre;
            lastToPre = pre;
            pre = cur;
        }
        return cur;
    }
}
