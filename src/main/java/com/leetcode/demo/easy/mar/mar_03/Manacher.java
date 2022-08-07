package com.leetcode.demo.easy.mar.mar_03;

import java.util.ArrayList;
import java.util.List;

public class Manacher {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(manacher(s));
    }

    public static String manacher(String s) {
        if (s == null || s.length() < 2) return s;

        StringBuilder sb = new StringBuilder("#");

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        s = sb.toString();
        int j = -1, right = -1;
        int start = 0, end = -1;

        List<Integer> armList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int curArm;
            if (i > right) {
                curArm = expand(s, i, i);
            } else {
                int symPoint = 2 * j - i;
                int minArm = Math.min(right - i, armList.get(symPoint));

                curArm = expand(s, i - minArm, i + minArm);
            }

            armList.add(curArm);
            if (i + curArm > right) {
                j = i;
                right = i + curArm;
            }

            if (2 * curArm + 1 > end - start) {
                start = i - curArm;
                end = i + curArm;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') res.append(s.charAt(i));
        }

        return res.toString();
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return (right - left - 2) / 2;
    }
}
