package com.leetcode.demo.mar.day26;

public class IsPalindrome {

    public static void main(String[] args) {
        // 输入：x = 121
        //输出：true
        System.out.println(new IsPalindrome().isPalindrome(10));
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
