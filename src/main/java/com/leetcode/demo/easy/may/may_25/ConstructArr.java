package com.leetcode.demo.easy.may.may_25;

import java.util.Arrays;

public class ConstructArr {

    public static void main(String[] args) {
        // 输入: [1,2,3,4,5]
        //输出: [120,60,40,30,24]

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new ConstructArr().constructArr(nums)));
    }

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return new int[0];
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
