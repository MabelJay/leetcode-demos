package com.leetcode.demo.aug_07;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        // 输入: s = "abcabcbb"
        //输出: 3

        String s = "cdd";
        String s2 = "dvdf";  // 2
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s2));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();

        int maxLen = Integer.MIN_VALUE;
        int tmpLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int pre = map.get(c);
                if (i - pre > tmpLen) {
                    tmpLen++;
                } else {
                    tmpLen = i - pre;
                }
            } else {
                tmpLen++;
            }
            maxLen = Math.max(maxLen, tmpLen);
            map.put(c, i);
        }
        return maxLen;
    }
}
