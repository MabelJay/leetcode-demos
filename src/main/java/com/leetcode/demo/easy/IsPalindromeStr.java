package com.leetcode.demo.easy;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsPalindromeStr {
    public static void main(String[] args) {
        //"A man, a plan, a canal: Panama"
        String s = "A man, a plan, a canal: Panama";
        char a = '0';
        char b = 'A';
        System.out.println((int) a);
        System.out.println((char) (a + 32));
        IsPalindromeStr palindromeStr = new IsPalindromeStr();
        System.out.println(palindromeStr.isPalindrome2(s));
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        if (s == null || s.length() == 0) return true;
        int len = s.length();
        int i = 0, j = len - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome3(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        StringBuilder sb2 = new StringBuilder(sb).reverse();
        return sb.toString().equals(sb2.toString());
    }
}
