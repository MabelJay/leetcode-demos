package com.leetcode.demo.easy;

public class IsSubsequence {

    public static void main(String[] args) {
        String s = "qb";
        String t = "aqdcb";

        System.out.println(new IsSubsequence().isSubsequence3(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) return false;
        if (s.length() == 0) return true;

        int i = 0, j = 0;
        int len1 = s.length();
        int len2 = t.length();

        while (true) {
            if (i == len1) return true;
            if (j == len2) return false;
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }
    }

    public boolean isSubsequence2(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) return false;
        if (s.length() == 0) return true;

        int i = 0, j = 0;
        int len1 = s.length();
        int len2 = t.length();

        while (i < len1 && j < len2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == len1;
    }

    public boolean isSubsequence3(String s, String t) {
        //s = "abc", t = "ahbgdc"
        int len1 = s.length(), len2 = t.length();
        int[][] f = new int[len2 + 1][26];
        for (int i = 0; i < 26; i++) {
            f[len2][i] = len2;
        }

        for (int i = len2 - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        int add = 0;
        for (int i = 0; i < len1; i++) {
            if (f[add][s.charAt(i) - 'a'] == len2) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
