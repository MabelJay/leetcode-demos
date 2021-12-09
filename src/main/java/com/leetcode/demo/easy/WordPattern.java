package com.leetcode.demo.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        //输入: pattern = "abba", str = "dog cat cat dog"
        //输出: true

        //"abba"
        //"dog dog dog dog"

        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(new WordPattern().wordPattern(pattern, str));
    }

    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) return false;

        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) return false;

        Map<Character, String> map = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            char temp = pattern.charAt(i);
            if (map.containsKey(temp)) {
                if (!map.get(temp).equals(arr[i])) return false;
            } else {
                if (map.containsValue(arr[i])) return false;
                map.put(temp, arr[i]);
            }
        }

        return true;
    }
}
