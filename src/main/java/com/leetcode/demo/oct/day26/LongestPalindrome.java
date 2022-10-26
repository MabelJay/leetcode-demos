package com.leetcode.demo.oct.day26;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    public static void main(String[] args) {
        // 输入：s = "babad"
        //输出："bab"

        // 输入：s = "cbbd"
        //输出："bb"

        String s = "cbbd";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        return manacher(s);
    }

    public String manacher(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        System.out.println(sb);
        s = sb.toString();

        int j = 0, right = -1;
        int start = 0, end = 0;
        List<Integer> armList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int cur;
            if (i >= right) {
                cur = expand(s, i, i);
            } else {
                int symPoint = 2 * j - i;
                int min = Math.min(armList.get(symPoint), right - i);
                cur = expand(s, i - min, i + min);
            }
            armList.add(cur);
            if (2 * cur + 1 > end - start) {
                end = i + cur;
                start = i - cur;
            }
            if (i + cur > right) {
                j = i;
                right = i + cur;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = start; i < end; i++) {
            if (s.charAt(i) != '#') {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }
}
