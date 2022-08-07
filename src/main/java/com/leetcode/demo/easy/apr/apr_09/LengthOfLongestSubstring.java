package com.leetcode.demo.easy.apr.apr_09;

import java.util.*;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        // 输入: s = "abcabcbb"
        //输出: 3

        String s = "abba";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring2(s));
        // 输入: s = "bbbbb"
        //输出: 1

        // 输入: s = "pwwkew"
        //输出: 3

        // "abba"
        // 2
    }

    // 动态规划
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        Map<Character, Integer> map = new HashMap<>();
        int index = 1;
        int max = 1;
        map.put(s.charAt(0), 0);
        while (index < len) {
            char temp = s.charAt(index);
            if (!map.containsKey(temp)) {
                dp[index] = dp[index - 1] + 1;
            } else {
                int prevIndex = map.get(temp);
                dp[index] = Math.min(index - prevIndex, dp[index - 1] + 1);
            }
            map.put(temp, index);
            max = Math.max(max, dp[index]);
            index++;
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    // 滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() < 2) return s.length();
        Set<Character> set = new HashSet<>();
        int index = 0;
        int rightIndex = 0;
        int maxLen = 0;
        while (index < s.length()) {
            if (index != 0) {
                set.remove(s.charAt(index - 1));
            }
            while (rightIndex < s.length() && !set.contains(s.charAt(rightIndex))) {
                set.add(s.charAt(rightIndex));
                rightIndex++;
            }
            maxLen = Math.max(maxLen, rightIndex - index);
            index++;
        }
        return maxLen;
    }

    // if (s == null || s.length() == 0) return 0;
    //        int rk = 0;
    //        int len = s.length();
    //        int maxLen = 0;
    //        Set<Character> set = new HashSet<>();
    //
    //        for (int i = 0; i < len; i++) {
    //            if (i != 0) {
    //                set.remove(s.charAt(i - 1));
    //            }
    //            while (rk < len && !set.contains(s.charAt(rk))) {
    //                set.add(s.charAt(rk));
    //                rk++;
    //            }
    //            maxLen = Math.max(maxLen, rk - i);
    //        }
    //        return maxLen;
}
