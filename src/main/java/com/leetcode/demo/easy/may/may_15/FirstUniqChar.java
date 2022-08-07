package com.leetcode.demo.easy.may.may_15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqChar {

    public static void main(String[] args) {
        // 输入：s = "abaccdeff"
        //输出：'b'

        String s = "abaccdeff";
        System.out.println(new FirstUniqChar().firstUniqChar(s));
    }

    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';

        char[] arr = new char[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            arr[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return s.charAt(i);
        }
        return ' ';
    }
}
