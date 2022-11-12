package com.leetcode.demo.nov.day12;

import java.util.ArrayList;
import java.util.List;

public class CountSubstrings {
    public static void main(String[] args) {
        // 输入：s = "abc"
        //输出：3

        // 输入：s = "aaa"
        //输出：6

        String s = "abc";
        System.out.println(new CountSubstrings().countSubstrings(s));

        String s2 = "aba";
        System.out.println(new CountSubstrings().manacher(s2));
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        return manacher(s);
    }

    public int manacher(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        s = sb.toString();
        List<Integer> armList = new ArrayList<>();
        int j = 0, right = -1;
        int start = 0, end = -1;
        int ans = 0;
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
            if (i > right) {
                j = i;
                right = i + cur;
            }
            ans += (cur + 1) / 2;
        }
        System.out.println(armList);
        return ans;
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
