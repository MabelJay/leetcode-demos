package com.leetcode.demo.easy.apr.apr_10;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    public static void main(String[] args) {
        // 输入: s = "leetcode"
        //输出: 0

        String s = "aabb";
        System.out.println(new FirstUniqChar().firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        if (s.length() == 1) return 0;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (arr[index] == 1) return i;
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        if (s.length() == 1) return 0;
        char[] arr = new char[128];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            arr[cs[i]]++;
        }
        for (int i = 0; i < cs.length; i++) {
            if (arr[cs[i]] == 1) return i;
        }
        return -1;
    }
}
