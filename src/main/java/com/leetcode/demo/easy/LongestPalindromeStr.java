package com.leetcode.demo.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeStr {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeStr().longestPalindrome2("abccccdd"));
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        int sumLen = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val % 2 == 0) sumLen += val;
            else {
                sumLen += (val - 1);
                flag = true;
            }
        }

        return flag ? sumLen + 1 : sumLen;
    }

    public int longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] count = new int[128];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            count[temp]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
