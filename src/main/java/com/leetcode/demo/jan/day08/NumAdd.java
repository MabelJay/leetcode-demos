package com.leetcode.demo.jan.day08;

public class NumAdd {

    public static void main(String[] args) {
        // 输入: a = 1, b = 1
        //输出: 2
        System.out.println(new NumAdd().add(15, 1));
    }

    public int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
}
