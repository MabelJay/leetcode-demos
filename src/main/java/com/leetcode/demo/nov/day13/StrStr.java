package com.leetcode.demo.nov.day13;

import java.util.Arrays;

public class StrStr {

    public static void main(String[] args) {
        // 输入：haystack = "sadbutsad", needle = "sad"
        //输出：0

        // 输入：haystack = "leetcode", needle = "leeto"
        //输出：-1

        String pattern = "leeto";
        String str = "leetcode";
        System.out.println(new StrStr().kmp(pattern, str));
    }

    public int strStr(String haystack, String needle) {

        return kmp(needle, haystack);
    }

    public int kmp(String pattern, String str) {
        int m = pattern.length();
        int n = str.length();

        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && pattern.charAt(j) != str.charAt(i)) {
                j = next[j - 1];
            }

            if (pattern.charAt(j) == str.charAt(i)) {
                j++;
                if (j == m) return i - j + 1;
            }
        }
        return -1;
    }
}
