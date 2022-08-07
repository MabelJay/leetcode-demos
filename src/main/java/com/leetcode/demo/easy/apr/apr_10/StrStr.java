package com.leetcode.demo.easy.apr.apr_10;

import java.util.Arrays;

public class StrStr {

    public static void main(String[] args) {
        // 输入：haystack = "hello", needle = "ll"
        //输出：2

        // 输入：haystack = "aaaaa", needle = "bba"
        //输出：-1

        String haystack = "aaaaa";
        String needle = "";

        // "mississippi"
        //"issip"
        String haystack1 = "mississippi";
        String needle1 = "issip";
        System.out.println(new StrStr().strStr(haystack1, needle1));
        System.out.println(new StrStr().strStr2(haystack1, needle1));
    }

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 < len2) return -1;

        int index = 0;
        int index2 = 0;

        int targetIndex = -1;
        while (index < len1 && index2 < len2) {
            if (haystack.charAt(index) == needle.charAt(index2)) {
                index++;
                index2++;
                targetIndex = index;
            } else {
                index = index - index2 + 1;
                index2 = 0;
            }
        }
        return index2 == len2 ? targetIndex - len2 : -1;
    }

    public int strStr2(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        int[] next = new int[m];

        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
            }
            next[i] = j;
        }

        System.out.println(Arrays.toString(next));

        j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == m) return i - j + 1;
            }
        }
        return -1;
    }

    // int n = haystack.length(), m = needle.length();
    //        if (m == 0) {
    //            return 0;
    //        }
    //        int[] pi = new int[m];
    //        for (int i = 1, j = 0; i < m; i++) {
    //            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
    //                j = pi[j - 1];
    //            }
    //            if (needle.charAt(i) == needle.charAt(j)) {
    //                j++;
    //            }
    //            pi[i] = j;
    //        }
    ////        System.out.println(Arrays.toString(pi));
    //        for (int i = 0, j = 0; i < n; i++) {
    //            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
    //                j = pi[j - 1];
    //            }
    //            if (haystack.charAt(i) == needle.charAt(j)) {
    //                j++;
    //            }
    //            if (j == m) {
    //                return i - m + 1;
    //            }
    //        }
    //        return -1;
}
