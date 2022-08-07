package com.leetcode.demo.easy.apr.apr_10;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    public static void main(String[] args) {
        // 输入：s = "cbbd"
        //输出："bb"

        // 输入：s = "babad"
        //输出："bab

        String s = "babad";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        return manacher(s);
    }

    public String manacher(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        System.out.println(sb);
        s = sb.toString();

        int j = -1, right = -1;
        int start = -1, end = -1;

        List<Integer> armList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int cur;
            if (i > right) {
                cur = expandArm(s, i, i);
            } else {
                int symPoint = 2 * j - i;
                int minArm = Math.min(armList.get(symPoint), right - i);
                cur = expandArm(s, i - minArm, i + minArm);
            }

            armList.add(cur);
            if (i + cur > right) {
                right = i + cur;
                j = i;
            }

            if (2 * cur + 1 > end - start) {
                start = i - cur;
                end = i + cur;
            }
        }

        System.out.println(armList);
        StringBuilder res = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') res.append(s.charAt(i));
        }
        return res.toString();
    }

    public int expandArm(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return (right - left - 2) / 2;
    }
}
