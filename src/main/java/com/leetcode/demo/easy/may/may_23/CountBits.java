package com.leetcode.demo.easy.may.may_23;

import java.util.Arrays;

public class CountBits {

    public static void main(String[] args) {
        // 输入: n = 2
        //输出: [0,1,1]
        //解释:

        // 输入: n = 5
        //输出: [0,1,1,2,1,2]

        System.out.println(Arrays.toString(new CountBits().countBits(5)));
    }

    public int[] countBits(int n) {
        int[] bitDp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bitDp[i] = bitDp[i & (i - 1)] + 1;
        }
        return bitDp;
    }
}
