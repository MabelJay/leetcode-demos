package com.leetcode.demo.sep_03;

import java.util.Arrays;

public class StrOfStr {

    public static void main(String[] args) {
        // 输入：haystack = "helloeeewwd", needle = "ww"
        //输出：2

        String str = "leetcode";
        String needle = "eetc";

        // "leetcode"
        //"leeto"
        System.out.println(new StrOfStr().strStr(str, needle));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        if (needle.equals("")) return 0;
        return kmp(haystack, needle);
    }

    public int kmp(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
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
            while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }

            if (str.charAt(i) == pattern.charAt(j)) {
                j++;
                if (j == m) return i - j + 1;
            }
        }
        return -1;
    }
}
