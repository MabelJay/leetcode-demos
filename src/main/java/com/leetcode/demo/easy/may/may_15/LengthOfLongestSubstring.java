package com.leetcode.demo.easy.may.may_15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        // 输入: "abcabcbb"
        //输出: 3

        // 输入: "bbbbb"
        //输出: 1

        // 输入: "pwwkew"
        //输出: 3

        // abba
        //2

        // "tmmzuxt"
        // 5
        String s = "abcabcbb";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring2(s));
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int index = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            while (index < s.length() && !set.contains(s.charAt(index))) {
                set.add(s.charAt(index));
                index++;
            }
            maxLen = Math.max(maxLen, index - i);
            set.remove(s.charAt(i));
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int tmpLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                tmpLen++;
                maxLen = Math.max(tmpLen, maxLen);
            } else {
                int preIndex = map.get(s.charAt(i));
                if (i - preIndex > tmpLen) {
                    tmpLen++;
                } else tmpLen = i - preIndex;
                maxLen = Math.max(maxLen, tmpLen);
            }
            map.put(s.charAt(i), i);
        }
        return maxLen;
    }
}
