package com.leetcode.demo.easy.feb.feb_22;

public class GetSum {

    public static void main(String[] args) {
        // 输入：a = 1, b = 2
        //输出：3
        // 10 11

        int a = 2;
        int b = 3;
        System.out.println(a | b);
        System.out.println(a ^ (a - 1));
        System.out.println(b ^ (b - 1));
        System.out.println(new GetSum().getSum(2, 3));
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
