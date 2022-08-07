package com.leetcode.demo.easy.apr.apr_09;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        // 输入：s = ['h','e','l','l','o']
        //输出：['o','l','l','e','h']

        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new ReverseString().reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }
    }
}
