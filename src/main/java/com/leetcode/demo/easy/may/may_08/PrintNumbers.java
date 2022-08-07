package com.leetcode.demo.easy.may.may_08;

import java.util.Arrays;

public class PrintNumbers {

    public static void main(String[] args) {
        // 输入: n = 1
        //输出: [1,2,3,4,5,6,7,8,9]

        System.out.println(Arrays.toString(new PrintNumbers().printNumbers(3)));
    }

    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n) - 1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
