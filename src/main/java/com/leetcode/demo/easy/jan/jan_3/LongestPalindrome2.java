package com.leetcode.demo.easy.jan.jan_3;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome2 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new LongestPalindrome2().longestPalindrome3(s));
    }

    public String longestPalindrome3(String s) {
        // generate special string
        StringBuilder sb = new StringBuilder("#");

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        System.out.println(sb);
        s = sb.toString();
        int start = 0, end = -1;
        int j = -1, right = -1;
        List<Integer> lenList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int curArm = 0;
            if (i > right) {
                curArm = expand(s, i, i);
            } else {
                int symPoint = 2 * j - i;
                int minArmLen = Math.min(right - i, lenList.get(symPoint));
                curArm = expand(s, i - minArmLen, i + minArmLen);
            }
            lenList.add(curArm);
            if (i + curArm > right) {
                right = i + curArm;
                j = i;
            }
            if (curArm * 2 + 1 > end - start) {
                end = i + curArm;
                start = i - curArm;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }
}
