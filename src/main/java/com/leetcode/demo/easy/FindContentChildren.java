package com.leetcode.demo.easy;

import java.util.Arrays;

public class FindContentChildren {

    public static void main(String[] args) {
        //输入: g = [1,2,3], s = [1,1]
        //输出: 1

        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(new FindContentChildren().findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        int len1 = g.length, len2 = s.length;

        while (i < len1 && j < len2) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
