package com.leetcode.demo.easy.may.may_29;

public class IsPalindrome {

    public static void main(String[] args) {
        // 输入: s = "A man, a plan, a canal: Panama"
        //输出: true

        // 输入: s = "race a car"
        //输出: false

        String s = "0P";
        System.out.println(new IsPalindrome().isPalindrome2(s));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (Character.isLetterOrDigit(temp)) sb.append(temp);
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public boolean isPalindrome2(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            while (right >= left && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            while (left <= right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            if (left > right) return true;
            if (s.charAt(left) == s.charAt(right) || Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else return false;
        }
        return true;
    }
}
