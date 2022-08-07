package com.leetcode.demo.easy.dec.dec_22;

import java.util.Arrays;

public class KmpDemo {

    public static void main(String[] args) {
        String s = "ABACABAD";
        String query = "ADEOABCDABDABACABAD";
        KmpDemo demo = new KmpDemo();
//        demo.kmp(query, s);
        System.out.println(demo.kmp4(query, s));
    }

    public void kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        int[] fail = new int[m];
        Arrays.fill(fail, -1);
        for (int i = 1; i < m; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        System.out.println(Arrays.toString(fail));

        int match = -1;
        for (int i = 1; i < n; ++i) {
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                match = fail[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                ++match;
                if (match == m - 1) {
                    System.out.println("true");
                }
            }
        }
        System.out.println("false");
    }

    public boolean kmp2(String query, String pattern) {
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

        int match = -1;
        for (int i = 0; i < n; i++) {
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                match = fail[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                match++;
                if (match == m - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean kmp3(String query, String pattern) {
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

    public boolean kmp4(String query, String pattern) {
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
}
