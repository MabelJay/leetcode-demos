package com.leetcode.demo.easy.apr.apr_09;

import java.util.Arrays;

public class KmpDemo {

    public static void main(String[] args) {
        String s = "ABACABAD";
        String query = "ADEOABCDABDABACABAD";

        System.out.println(new KmpDemo().kmp(query, s));
    }

    public static int kmp(String query, String pattern) {
        int m = pattern.length();
        int n = query.length();
        int[] next = new int[m];

        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        System.out.println("next arr: " + Arrays.toString(next));

        j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && query.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }

            if (query.charAt(i) == pattern.charAt(j)) {
                j++;
                if (j == m) return i - m + 1;
            }
        }
        return -1;
    }
}
