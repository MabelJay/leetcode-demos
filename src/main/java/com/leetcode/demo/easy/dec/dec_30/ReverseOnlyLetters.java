package com.leetcode.demo.easy.dec.dec_30;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ReverseOnlyLetters {

    public static void main(String[] args) {

        //输入："a-bC-dEf-ghIj"
        //输出："j-Ih-gfE-dCba"
        // j-Ih-gfE-dCba

        //"ab-cd"

        //[j, -, I, h, -, g, f, E, -, d, C, b, a]

        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters4("a-bC-dEf-ghIj"));
    }

    public String reverseOnlyLetters2(String s) {
        if (s == null || s.length() < 2) return s;

        int len = s.length();
        int left = 0, right = len - 1;

        StringBuilder sb = new StringBuilder(s);
        while (left < right) {
            while (left < right && !Character.isLetter(sb.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetter(sb.charAt(right))) {
                right--;
            }

            if (left < right) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
        }
        return sb.toString();
    }

    public String reverseOnlyLetters3(String s) {
        if (s == null || s.length() < 2) return s;

        StringBuilder sb = new StringBuilder();
        int left = 0, right = s.length() - 1;
        while (left < s.length()) {
            if (Character.isLetter(s.charAt(left))) {
                while (!Character.isLetter(s.charAt(right))) {
                    right--;
                }
                sb.append(s.charAt(right--));
            } else {
                sb.append(s.charAt(left));
            }
            left++;
        }
        return sb.toString();
    }

    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() < 2) return s;
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (Character.isLetter(temp)) {
                sb.append(stack.pop());
            } else {
                sb.append(temp);
            }
        }
        return sb.toString();
    }

    public String reverseOnlyLetters4(String s) {
        if (s == null || s.length() < 2) return s;

        int len = s.length();
        int left = 0, right = len - 1;

        char[] arr = s.toCharArray();
        while (left < right) {
            while (left < right && !Character.isLetter(arr[left])) {
                left++;
            }

            while (left < right && !Character.isLetter(arr[right])) {
                right--;
            }

            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(arr);
    }
}
