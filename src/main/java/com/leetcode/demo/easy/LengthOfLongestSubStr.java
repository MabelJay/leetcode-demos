package com.leetcode.demo.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubStr {
    public static void main(String[] args) {
        String s = "abba";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "aab";
        LengthOfLongestSubStr subStr = new LengthOfLongestSubStr();
        System.out.println(subStr.lengthOfLongestSubstring2(s));
        System.out.println(subStr.lengthOfLongestSubstring2(s2));
        System.out.println(subStr.lengthOfLongestSubstring2(s3));
        System.out.println(subStr.lengthOfLongestSubstring2(s4));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int maxLen = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (maxLen < (i - start)) {
                    maxLen = i - start;
                }
                if (start < (map.get(s.charAt(i)) + 1)) {
                    start = map.get(s.charAt(i)) + 1;
                }
            }
            map.put(s.charAt(i), i);
            if (maxLen < (i - start + 1)) {
                maxLen = i - start + 1;
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        int rk = 0;
        int len = s.length();
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk < len && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                rk++;
            }
            maxLen = Math.max(maxLen, rk - i);
        }
        return maxLen;
    }
}
