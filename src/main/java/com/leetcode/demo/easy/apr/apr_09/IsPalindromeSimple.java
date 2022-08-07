package com.leetcode.demo.easy.apr.apr_09;

public class IsPalindromeSimple {
    public static void main(String[] args) {
        // 输入: "A man, a plan, a canal: Panama"
        //输出: true
        //解释："amanaplanacanalpanama" 是回文串

        String s = "A man, a plan, a canal: Panama";
        System.out.println(new IsPalindromeSimple().isPalindrome2(s));
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return isPalindrome(sb);
    }

    public boolean isPalindrome(StringBuilder sb) {
        String s = sb.toString();
        return sb.reverse().toString().equals(s);
    }

    public boolean isPalindrome2(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    //  if (s == null || s.length() == 0) return true;
    //        int len = s.length();
    //        int i = 0, j = len - 1;
    //        while (i < j) {
    //            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
    //                i++;
    //            }
    //            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
    //                j--;
    //            }
    //            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
    //                return false;
    //            }
    //            i++;
    //            j--;
    //        }
    //        return true;
}
