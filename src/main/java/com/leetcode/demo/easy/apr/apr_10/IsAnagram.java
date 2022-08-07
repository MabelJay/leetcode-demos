package com.leetcode.demo.easy.apr.apr_10;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public static void main(String[] args) {
        // 输入: s = "anagram", t = "nagaram"
        //输出: true

        // 输入: s = "rat", t = "car"
        //输出: false

        // "ab"
        //"a"

        String s = "ab";
        String t = "a";
        System.out.println(new IsAnagram().isAnagram2(s, t));
    }

    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            arr[index]--;
            if (arr[index] < 0) return false;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        System.out.println(map);
        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            if (!map.containsKey(temp)) return false;
            else {
                int frequency = map.get(temp);
                if (frequency < 1) return false;
                map.put(temp, frequency - 1);
            }
        }
        return true;
    }
}
