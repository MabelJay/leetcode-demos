package com.leetcode.demo.mar.day03;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        // 输入: s = "abcabcbb"
        //输出: 3

        // 输入: s = "pwwkew"
        //输出: 3

        String s = "abba";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int len = s.length();
        int maxLen = 0;

        while (right < len) {
            char temp = s.charAt(right);
            if (map.containsKey(temp)) {
                left = left > map.get(temp) ? left : map.get(temp) + 1;
            }
            map.put(temp, right);
            right++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
