package com.leetcode.demo.easy.dec.dec_23;

/*
    给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        //输入: s = "aba"
        //输出: true

        //输入: s = "abc"
        //输出: false

        // "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"
        String s = "cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu";
        System.out.println(new ValidPalindrome().validPalindrome(s));
    }

    public boolean validPalindrome2(String s) {
        if (s == null || s.length() == 0) return false;
        if (isPalindrome(s)) return true;

        int len = s.length();
        int low = 0, high = len - 1;
        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return isPalindrome(s.substring(low + 1, high + 1)) || isPalindrome(s.substring(low, high));
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                ++low;
                --high;
            } else {
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        return true;
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
