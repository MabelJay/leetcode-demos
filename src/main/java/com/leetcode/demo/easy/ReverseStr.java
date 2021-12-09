package com.leetcode.demo.easy;

import java.util.Arrays;

public class ReverseStr {

    public static void main(String[] args) {
        // 输入：s = ["h","e","l","l","o"]
        //输出：["o","l","l","e","h"]

        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        new ReverseStr().reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int len = s.length;

        for (int i = 0; i < (len >> 1); i++) {
            swap(s, i, len - i - 1);
        }

    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
