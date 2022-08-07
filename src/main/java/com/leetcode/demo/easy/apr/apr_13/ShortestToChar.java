package com.leetcode.demo.easy.apr.apr_13;

import java.util.Arrays;

public class ShortestToChar {

    public static void main(String[] args) {
        // 输入：s = "loveleetcode", c = "e"
        //输出：[3,2,1,0,1,0,0,1,2,2,1,0]

        // [3,2,1,0,1,0,0,1,2,2,1,0]
        // [3,2,1,0,1,0,0,1,2,2,1,0]
        String s = "aaab";
        char c = 'b';
        System.out.println(Arrays.toString(new ShortestToChar().shortestToChar2(s, c)));
    }

    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] preArr = new int[len];
        int[] backArr = new int[len];

        int pre = -len;
        int back = 2 * len;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                preArr[i] = 0;
                pre = i;
            } else preArr[i] = i - pre;
            int rightIndex = len - i - 1;
            if (s.charAt(rightIndex) == c) {
                backArr[rightIndex] = 0;
                back = rightIndex;
            } else backArr[rightIndex] = back - rightIndex;
        }

        for (int i = 0; i < len; i++) {
            preArr[i] = Math.min(preArr[i], backArr[i]);
        }
        return preArr;
    }

    public int[] shortestToChar2(String s, char c) {
        int len = s.length();
        int[] resArr = new int[len];

        int pre = -len;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                pre = i;
                resArr[i] = 0;
            } else resArr[i] = i - pre;
        }

        pre = 2 * len;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pre = i;
            } else resArr[i] = Math.min(pre - i, resArr[i]);
        }
        return resArr;
    }

    //  int len = s.length();
    //        int[] resArr = new int[len];
    //        int pre = Integer.MIN_VALUE / 2;
    //        for (int i = 0; i < len; i++) {
    //            if (s.charAt(i) == c) {
    //                resArr[i] = 0;
    //                pre = i;
    //            } else resArr[i] = i - pre;
    //        }
    //        pre = Integer.MAX_VALUE;
    //        for (int i = len - 1; i >= 0; i--) {
    //            if (s.charAt(i) == c) pre = i;
    //            else resArr[i] = Math.min(resArr[i], pre - i);
    //        }
    //        return resArr;
}
