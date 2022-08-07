package com.leetcode.demo.easy.dec.dec_29;

import java.util.Arrays;

public class RotateString {

    public static void main(String[] args) {
        //示例 1:
        //输入: A = 'abcde', B = 'cdeab'
        //输出: true
        //
        //示例 2:
        //输入: A = 'abcde', B = 'abced'
        //输出: false
        String a = "abcde";
        String b = "abced";
        String a1 = a + a;
        String segment = a1.substring(1, a1.length() - 1);
        System.out.println(segment.indexOf(b) >= 0);
        System.out.println(new RotateString().rotateString2(a, b));
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String newStr = s + s;
        return kmp(goal, newStr.substring(1, newStr.length() - 1));
    }

    public boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public boolean kmp(String pattern, String query) {
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

        int matches = -1;
        for (int i = 0; i < n; i++) {
            while (matches != -1 && pattern.charAt(matches + 1) != query.charAt(i)) {
                matches = fail[matches];
            }

            if (query.charAt(i) == pattern.charAt(matches + 1)) {
                matches++;
                if (matches == m - 1) return true;
            }
        }
        return false;
    }
}
