package com.leetcode.demo.mar.day03;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    public static void main(String[] args) {
        // 输入：s = "cbbd"
        //输出："bb"
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        s = sb.toString();
        int j = -1, right = -1;
        int start = 0, end = -1;
        List<Integer> armList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int cur;
            if (i > right) {
                cur = expand(s, i, i);
            } else {
                int symPoint = 2 * j - i;
                int minArm = Math.min(armList.get(symPoint), right - i);
                cur = expand(s, i - minArm, i + minArm);
            }
            armList.add(cur);
            if (2 * cur + 1 > end - start) {
                start = i - cur;
                end = i + cur;
            }

            if (i + cur > right) {
                right = i + cur;
                j = i;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = start; i < end; i++) {
            if (s.charAt(i) != '#') res.append(s.charAt(i));
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
