package com.leetcode.demo.jan.day03;

import java.util.Arrays;

public class KmpDemo {
    public static void main(String[] args) {
        String str = "leetcode";
        String needle = "eetc";
//        System.out.println(kmp(needle, str));
        System.out.println(kmp2(needle, str));
    }

    public static int kmp(String pattern, String source) {
        if (pattern == null || source == null || source.length() < pattern.length()) return -1;
        int m = pattern.length();
        int n = source.length();

        int[] next = new int[m];

        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) j++;
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && pattern.charAt(j) != source.charAt(i)) {
                j = next[j - 1];
            }
            if (pattern.charAt(j) == source.charAt(i)) {
                j++;
                if (j == m) return i - m + 1;
            }
        }
        return -1;
    }

    public static int kmp2(String pattern, String str) {
        if (pattern == null || str == null || pattern.length() > str.length()) return -1;

        int m = pattern.length();
        int n = str.length();
        int[] next = getNextArr(pattern);
        System.out.println(Arrays.toString(next));

        int index1 = 0, index2 = 0;
        while (index1 < n && index2 < m) {
            if (str.charAt(index1) == pattern.charAt(index2)) {
                index1++;
                index2++;
            } else if (index2 == 0) {
                index1++;
            } else index2 = next[index2];
        }
        return index2 == m ? index1 - m : -1;
    }

    public static int[] getNextArr(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        next[0] = -1;
        next[1] = 0;

        int cnt = 0;
        int i = 2;
        while (i < m) {
            if (pattern.charAt(i - 1) == pattern.charAt(cnt)) {
                next[i++] = ++cnt;
            } else if (cnt > 0) cnt = next[cnt];
            else next[i++] = 0;
        }
        return next;
    }
}
