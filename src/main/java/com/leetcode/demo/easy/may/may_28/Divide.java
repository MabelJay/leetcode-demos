package com.leetcode.demo.easy.may.may_28;

public class Divide {

    public static void main(String[] args) {
        System.out.println(new Divide().divide(Integer.MIN_VALUE, 2));
    }

    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE) {
            if (b == 1) return a;
            if (b == -1) return Integer.MAX_VALUE;
        }
        if (b == Integer.MIN_VALUE) {
            if (a == Integer.MIN_VALUE) return 1;
            else return 0;
        }
        if (a == 0 || b == 1) return a;
        boolean isNegative = (a ^ b) < 0;
        a = a < 0 ? a : -a;
        b = b < 0 ? b : -b;
        int count = 0;
        while (a <= b) {
            int base = 1;
            int diff = b;
            while (a - diff <= diff) {
                base <<= 1;
                diff <<= 1;
            }
            count += base;
            a = a - diff;
        }
        return isNegative ? -count : count;
    }
}
