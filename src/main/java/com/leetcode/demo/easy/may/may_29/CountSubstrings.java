package com.leetcode.demo.easy.may.may_29;

import java.util.ArrayList;
import java.util.List;

public class CountSubstrings {

    public static void main(String[] args) {
        // 输入：s = "abc"
        //输出：3

        // 输入：s = "aaa"
        //输出：6

        String s = "aaa";
        System.out.println(new CountSubstrings().countSubstrings2(s));
    }

    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0) return 0;

        int count = 0;
        int len = s.length();
        for (int i = 0; i < len * 2 - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
        }
        return count;
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        System.out.println(sb);
        s = sb.toString();

        int right = -1, j = -1;
        List<Integer> armList = new ArrayList<>();
        int count = 0;
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
            if (i + cur > right) {
                right = i + cur;
                j = i;
            }
            count += (cur + 1) / 2;
        }
        return count;
    }

    public int expand(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return (end - start - 2) / 2;
    }
}
