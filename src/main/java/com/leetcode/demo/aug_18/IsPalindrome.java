package com.leetcode.demo.aug_18;

public class IsPalindrome {

    public static void main(String[] args) {
        // 输入：x = 121
        //输出：true

        System.out.println(new IsPalindrome().isPalindrome3(13));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        return sb.toString().equals(sb.reverse().toString());
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        String temp = String.valueOf(x);
        for (int i = 0; i < temp.length() / 2; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length() - i - 1)) return false;
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int left = 0;
        while (x > left) {
            left = left * 10 + x % 10;
            x /= 10;
        }
        return x == left || x == left / 10;
    }
}
