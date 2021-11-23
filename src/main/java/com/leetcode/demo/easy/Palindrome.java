package com.leetcode.demo.easy;

public class Palindrome {
    public static void main(String[] args) {
        int x = 121;
        int x2 = 10;
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome2(x));
        System.out.println(palindrome.isPalindrome2(x2));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        char[] arr = s.toCharArray();
        int len = arr.length;
        int i = 0, j = len - 1;
        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return rev == x || x == (rev) / 10;
    }
}
