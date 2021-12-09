package com.leetcode.demo.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

    public static void main(String[] args) {
        // 输入：s = "hello"
        //输出："holle"
        //"SorE was I ere I saw eros."
        String s = "Sore was I ere I saw Eros.";
        // SorE was I ere I saw eros.
        //SorE was I ere I saw eros.
        //SorE was I ere I saw eros.
        System.out.println(new ReverseVowels().reverseVowels3(s));
        char ch1 = 'A';
        System.out.println((char) (ch1 + 32));
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;

        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int len = s.length();
        int left = 0, right = len - 1;
        while (left < right) {
            if (set.contains(arr[right])) {
                while (left < right && !set.contains(arr[left])) {
                    left++;
                }
                if (left < right) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                } else {
                    break;
                }
            }
            right--;
        }
        return String.valueOf(arr);
    }

    public String reverseVowels2(String s) {
        if (s == null || s.length() == 0) return s;

        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int len = s.length();
        int left = 0, right = len - 1;
        while (left < right) {
            if (set.contains(arr[right]) || set.contains(Character.toLowerCase(arr[right]))) {
                while (left < right && !set.contains(arr[left]) && !set.contains(Character.toLowerCase(arr[left]))) {
                    left++;
                }
                if (left < right) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                } else {
                    break;
                }
            }
            right--;
        }
        return String.valueOf(arr);
    }

    public String reverseVowels3(String s) {
        if (s == null || s.length() == 0) return s;

        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (left < right && !isVowel(arr[left])) {
                left++;
            }

            while (left < right && !isVowel(arr[right])) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
