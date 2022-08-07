package com.leetcode.demo.easy.apr.apr_09;

public class IsPalindrome {
    public static void main(String[] args) {
        // 输入：x = 121
        //输出：true

        System.out.println(new IsPalindrome().isPalindrome2(10));

        // 输入：x = 10
        //输出：false
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) return false;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int left = 0;
        while (x > left) {
            left = left * 10 + x % 10;
            x /= 10;
        }
        return left == x || x == (left) / 10;
    }
}

//f (x < 0 || (x % 10 == 0 && x != 0)) return false;
//        int rev = 0;
//        while (x > rev) {
//            rev = rev * 10 + x % 10;
//            x = x / 10;
//        }
//        return rev == x || x == (rev) / 10;