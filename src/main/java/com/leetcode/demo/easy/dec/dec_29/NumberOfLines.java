package com.leetcode.demo.easy.dec.dec_29;

import java.util.Arrays;

public class NumberOfLines {

    public static void main(String[] args) {
        //widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
        //S = "abcdefghijklmnopqrstuvwxyz"
        //输出: [3, 60]

        // [3,4,10,4,8,7,3,3,4,9,8,2,9,6,2,8,4,9,9,10,2,4,9,10,8,2]
        //"mqblbtpvicqhbrejb"
        int[] widths = {3, 4, 10, 4, 8, 7, 3, 3, 4, 9, 8, 2, 9, 6, 2, 8, 4, 9, 9, 10, 2, 4, 9, 10, 8, 2};
        String s = "mqblbtpvicqhbrejb";
        System.out.println(Arrays.toString(new NumberOfLines().numberOfLines2(widths, s)));
    }

    public int[] numberOfLines(int[] widths, String s) {
        int sum = 0;
        int len = s.length();
        int row = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            sum += widths[c - 'a'];
            if (sum >= 100) {
                row++;
                if (sum == 100) {
                    if (i == len - 1) {
                        return new int[]{row, sum};
                    } else {
                        sum -= 100;
                    }
                } else {
                    sum = widths[c - 'a'];
                    if (i == len - 1) {
                        return new int[]{row + 1, sum};
                    }
                }
            }
        }
        return new int[]{row + 1, sum};
    }

    public int[] numberOfLines2(int[] widths, String s) {
        int row = 1, sum = 0;
        for (char c : s.toCharArray()) {
            sum += widths[c - 'a'];
            if (sum > 100) {
                row++;
                sum = widths[c-'a'];
            }
        }
        return new int[]{row, sum};
    }
}
