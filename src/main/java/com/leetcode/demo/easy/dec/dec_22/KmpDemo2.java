package com.leetcode.demo.easy.dec.dec_22;

import java.util.Arrays;

public class KmpDemo2 {
    public static void main(String[] args) {
        String query = "BBC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";

        System.out.println(new KmpDemo2().kmp(query, pattern));
        System.out.println(new KmpDemo2().kmp2(query, pattern));
        System.out.println(new KmpDemo2().kmp3(query, pattern));
    }

    public boolean kmp(String query, String pattern) {
        int m = pattern.length();
        int n = query.length();
        int[] fail = new int[m];
        Arrays.fill(fail, -1);

        for (int i = 1; i < m; i++) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }

            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        System.out.println(Arrays.toString(fail));

        int matches = -1;
        for (int i = 0; i < n; i++) {
            while (matches != -1 && pattern.charAt(matches + 1) != query.charAt(i)) {
                matches = fail[matches];
            }

            if (pattern.charAt(matches + 1) == query.charAt(i)) {
                matches++;
                if (matches == m - 1) return true;
            }
        }
        return false;
    }

    public int kmp2(String query, String pattern) {
        int m = pattern.length();
        int n = query.length();

        int[] fail = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = fail[j - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
            }
            fail[i] = j;
        }
        System.out.println(Arrays.toString(fail));

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && pattern.charAt(j) != query.charAt(i)) {
                j = fail[j - 1];
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

    public int kmp3(String query, String pattern) {
        int m = pattern.length();
        int n = query.length();
        if (m > n) return -1;
        int[] next = new int[m];

        for (int i = 1, j = 0; i < m; i++) {
            while (j != 0 && pattern.charAt(j) != pattern.charAt(i)) {
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
