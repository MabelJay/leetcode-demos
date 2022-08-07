package com.leetcode.demo.easy.jan.jan_3;

import java.util.Arrays;

public class KmpDemo4 {

    public static void main(String[] args) {
        String query = "BBC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";

        System.out.println(new KmpDemo4().kmp(query, pattern));
    }

    public int kmp(String query, String pattern) {
        int m = pattern.length();
        int n = query.length();
        int[] next = new int[m];

        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = next[j - 1];
            }

            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
            }
            next[i] = j;
        }

        System.out.println(Arrays.toString(next));

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && pattern.charAt(j) != query.charAt(i)) {
                j = next[j - 1];
            }

            if (pattern.charAt(j) == query.charAt(i)) {
                j++;
                if (j == m) {
                    return i - j + 1;
                }
            }
        }
        return -1;
    }
}
