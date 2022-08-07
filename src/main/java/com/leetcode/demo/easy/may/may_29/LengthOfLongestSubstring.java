package com.leetcode.demo.easy.may.may_29;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        //输入: s = "abcabcbb"
        //输出: 3

        // 输入: s = "bbbbb"
        //输出: 1

        // "tmmzuxt"
        // 5
        String s = "bbbbb";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 1;
        int index = 0;
        int tmpLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (index < s.length()) {
            char temp = s.charAt(index);
            if (map.containsKey(temp)) {
                int preIndex = map.get(temp);
                tmpLen = Math.min(++tmpLen, index - preIndex);
                map.put(temp, index);
            } else {
                map.put(temp, index);
                tmpLen++;
            }
            index++;
            maxLen = Math.max(maxLen, tmpLen);
        }
        return maxLen;
    }
}
