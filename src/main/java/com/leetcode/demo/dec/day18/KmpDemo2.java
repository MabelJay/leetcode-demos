package com.leetcode.demo.dec.day18;

import java.util.Arrays;

public class KmpDemo2 {

    public static void main(String[] args) {
        String s = "abcbebabebbcf";
        String p = "bebb";

        System.out.println(kmp1(s, p));
        System.out.println(kmp2(s, p));
    }

    public static int kmp1(String s, String p) {
        if (s == null || p == null || p.length() == 0 || s.length() < p.length()) return -1;

        int m = p.length();
        int n = s.length();
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) j++;
            next[i] = j;
        }

        System.out.println(Arrays.toString(next));
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }

            if (s.charAt(i) == p.charAt(j)) {
                j++;
                if (j == m) return i - m + 1;
            }
        }
        return -1;
    }

    public static int kmp2(String s, String p) {
        if (s == null || p == null || p.length() == 0 || s.length() < p.length()) return -1;
        int m = p.length();
        int n = s.length();

        int[] next = getNextArr(p);
        System.out.println(Arrays.toString(next));

        int index1 = 0, index2 = 0;
        while (index1 < n && index2 < m) {
            if (s.charAt(index1) == p.charAt(index2)) {
                index1++;
                index2++;
            } else if (next[index2] == -1) {
                index1++;
            } else {
                index2 = next[index2];
            }
        }
        return index2 == m ? index1 - m : -1;
    }

    public static int[] getNextArr(String p) {
        int m = p.length();
        int[] next = new int[m];

        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;

        while (i < m) {
            if (p.charAt(i - 1) == p.charAt(cn)) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
