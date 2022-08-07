package com.leetcode.demo.easy.dec.dec_30;

import java.util.*;

public class ShortestToChar {

    public static void main(String[] args) {
        // 输入：s = "loveleetcode", c = "e"
        //输出：[3,2,1,0,1,0,0,1,2,2,1,0]
        String s = "loveleetcode";
        char c = 'e';

        System.out.println(Arrays.toString(new ShortestToChar().shortestToChar(s, c)));
    }

    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] resArr = new int[len];
        int pre = Integer.MIN_VALUE / 2;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                resArr[i] = 0;
                pre = i;
            } else resArr[i] = i - pre;
        }
        pre = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == c) pre = i;
            else resArr[i] = Math.min(resArr[i], pre - i);
        }
        return resArr;
    }
}
