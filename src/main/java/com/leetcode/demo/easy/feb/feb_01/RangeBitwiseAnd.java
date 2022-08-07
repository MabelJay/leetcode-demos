package com.leetcode.demo.easy.feb.feb_01;

import java.util.Set;

public class RangeBitwiseAnd {

    public static void main(String[] args) {
        // 输入：left = 5, right = 7
        //输出：4

        // 输入：left = 1, right = 2147483647
        //输出：0

        // 2147483646
        //2147483647

        // 600000000
        //2147483645

        // 2147483647
        //2147483647
//        System.out.println(Integer.MAX_VALUE);

        // 600000000
        //2147483645
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(5, 7));
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd2(5, 7));
//        System.out.println(600000000 & 700000000);
    }

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    public int rangeBitwiseAnd2(int left, int right) {
        while (left < right) {
            right &= right - 1;
        }
        return right;
    }
}
