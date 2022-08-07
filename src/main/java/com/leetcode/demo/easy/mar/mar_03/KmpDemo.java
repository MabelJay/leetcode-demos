package com.leetcode.demo.easy.mar.mar_03;

public class KmpDemo {

    public static void main(String[] args) {
        String query = "absdseab";
        String pattern = "seab";

        System.out.println(kmp(pattern, query));
    }

    public static int kmp(String pattern, String query) {
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

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && query.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }

            if (pattern.charAt(j) == query.charAt(i)) {
                j++;
                if (j == m) return i - m + 1;
            }
        }
        return -1;
    }
}
