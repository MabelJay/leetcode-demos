package com.leetcode.demo.easy.jan.jan_9;

import java.util.ArrayList;
import java.util.List;

public class Manacher {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Manacher().longestPalindrome2(s));
        System.out.println(new Manacher().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        System.out.println(sb);
        s = sb.toString();
        int start = 0, end = -1;
        int right = -1, j = -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int curArm;
            if (i > right) {
                curArm = expand(s, i, i);
            } else {
                int symPoint = 2 * j - i;
                int minArm = Math.min(list.get(symPoint), right - i);
                curArm = expand(s, i - minArm, i + minArm);
            }
            list.add(curArm);
            if (i + curArm > right) {
                right = i + curArm;
                j = i;
            }

            if (2 * curArm + 1 > end - start) {
                start = i - curArm;
                end = i + curArm;
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') {
                sb2.append(s.charAt(i));
            }
        }
        return sb2.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) return s;
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) + "#");
        }
        System.out.println(sb);
        s = sb.toString();
        List<Integer> armList = new ArrayList<>();

        int start = 0, end = -1;
        int j = -1, right = -1;
        for (int i = 0; i < s.length(); i++) {
            int curArm;
            if (i > right) {
                curArm = expand(s, i, i);
            } else {
                int symPoint = 2 * j - i;
                int minArm = Math.min(armList.get(symPoint), right - i);
                curArm = expand2(s, i - minArm, i + minArm);
            }

            armList.add(curArm);

            if (i + curArm > right) {
                right = i + curArm;
                j = i;
            }

            if (2 * curArm + 1 > end - start) {
                start = i - curArm;
                end = i + curArm;
            }
        }

        StringBuilder res = new StringBuilder();
        System.out.println("start=" + start + "end=" + end);
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public int expand2(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return (r - l - 2) / 2;
    }
}
