package com.leetcode.demo.aug_20;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int ret = 0;
        while (x > ret) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }

        return x == ret || x == ret / 10;
    }
}
