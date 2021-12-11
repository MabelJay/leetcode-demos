package com.leetcode.demo.easy;

import java.util.Arrays;

public class FindStr {
    public static void main(String[] args) {
        String haystack = "aabaaab";
        String needle = "aba";
        System.out.println(new FindStr().subStr3(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.equals("")) return 0;

        int targetLen = needle.length();
        int len = haystack.length();
        for (int i = 0; i <= (len - targetLen); i++) {
            String temp = haystack.substring(i, i + targetLen);
            if (temp.equals(needle)) return i;
        }
        return -1;
    }

    //  aabaaab aba
    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        System.out.println(Arrays.toString(pi));
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    // KMP
    public int subStr3(String sourceStr, String destStr) {
        int sourceLen = sourceStr.length();
        int destLen = destStr.length();

        if (destLen == 0) return 0;
        int[] pi = new int[destLen];
        for (int i = 1, j = 0; i < destLen; i++) {
            while (j > 0 && destStr.charAt(i) != destStr.charAt(j)) {
                j = pi[j - 1];
            }
            if (destStr.charAt(i) == destStr.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }

        System.out.println(Arrays.toString(pi));

        for (int i = 0, j = 0; i < sourceLen; i++) {
            while (j > 0 && sourceStr.charAt(i) != destStr.charAt(j)) {
                j = pi[j - 1];
            }
            if (sourceStr.charAt(i) == destStr.charAt(j)) {
                j++;
            }
            if (j == destLen) {
                return i - destLen + 1;
            }
        }
        return -1;
    }
}
