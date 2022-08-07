package com.leetcode.demo.easy.apr.apr_14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public static void main(String[] args) {
        // 输入: pattern = "abba", str = "dog cat cat dog"
        //输出: true

        // 输入:pattern = "abba", str = "dog cat cat fish"
        //输出: false

        // 输入: pattern = "aaaa", str = "dog cat cat dog"
        //输出: false

        String pattern = "abc";
        String str = "dog cat dog";

        // "abba"
        //"dog cat cat dog"

        // "abba"
        //"dog cat cat dog"

        ///"abc"
        //"dog cat dog"
        System.out.println(new WordPattern().wordPattern(pattern, str));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        if (pattern.length() != arr.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char temp = pattern.charAt(i);
            if (map.containsKey(temp)) {
                if (!map.get(temp).equals(arr[i])) return false;
            } else {
                if (set.contains(arr[i])) return false;
                map.put(temp, arr[i]);
                set.add(arr[i]);
            }
        }
        return true;
    }
}
