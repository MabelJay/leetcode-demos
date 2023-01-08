package com.leetcode.demo.jan.day08;

public class NumMultiply {

    public static void main(String[] args) {
        System.out.println(new NumMultiply().multiply2(12, 2));
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

    public int add(int num1, int num2) {
        int sum = num1;
        while (num2 != 0) {
            sum = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return sum;
    }

    public int multiply2(int A, int B) {
        if (A == 0 || B == 0) return 0;
        return (B & 1) != 0 ? (A + multiply2(A << 1, B >>> 1)) : multiply2(A << 1, B >>> 1);
    }
}
