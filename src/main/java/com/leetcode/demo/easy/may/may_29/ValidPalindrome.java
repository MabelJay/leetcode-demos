package com.leetcode.demo.easy.may.may_29;

public class ValidPalindrome {

    public static void main(String[] args) {
        // 输入: s = "aba"
        //输出: true

        // 输入: s = "abca"
        //输出: true

        // 输入: s = "abc"
        //输出: false

        // s = "abac"
        // true

        // ececabbacec
        // true
        String s = "ececabbacec";
        System.out.println(new ValidPalindrome().validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

    public boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}