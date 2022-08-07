package com.leetcode.demo.easy.feb.feb_12;

import java.util.Arrays;

public class KmpDemo {

    public static void main(String[] args) {
        String s = "ABACABAD";
        String query = "ADEOABCDABDABACABAD";
        System.out.println(kmp(s, query));
    }

    public static int kmp(String pattern, String query) {
        int m = pattern.length();
        int n = query.length();
        int[] next = new int[m];

        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = next[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            next[i] = j;
        }

        System.out.println(Arrays.toString(next));

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && query.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }

            if (query.charAt(i) == pattern.charAt(j)) {
                j++;
                if (j == m) {
                    return i - j + 1;
                }
            }
        }
        return -1;
    }
}
