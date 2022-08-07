package com.leetcode.demo.easy.may.may_09;

public class HammingWeight {

    public static void main(String[] args) {
        // 输入：n = 11 (控制台输入 00000000000000000000000000001011)
        //输出：3

        // 输入：n = 128 (控制台输入 00000000000000000000000010000000)
        //输出：1

        // 输入：n = 4294967293 (控制台输入 11111111111111111111111111111101，部分语言中 n = -3）
        //输出：31

        System.out.println(Integer.toBinaryString(-3));
        System.out.println(new HammingWeight().hammingWeight(-3));
    }

    public int hammingWeight(int n) {
        System.out.println(Integer.toBinaryString(n));
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) count++;
            n >>>= 1;
        }
        return count;
    }
}
