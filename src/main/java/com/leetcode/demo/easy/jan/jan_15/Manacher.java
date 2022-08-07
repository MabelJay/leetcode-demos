package com.leetcode.demo.easy.jan.jan_15;

import java.util.ArrayList;
import java.util.List;

public class Manacher {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(manacherCompute(s));
    }

    public static String manacherCompute(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }

        System.out.println(sb);
        s = sb.toString();

        int len = s.length();
        int start = 0, end = -1;
        int j = -1, right = -1;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
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
                j = i;
                right = i + curArm;
            }

            if (2 * curArm + 1 > end - start) {
                end = i + curArm;
                start = i - curArm;
            }
        }

        System.out.println(list);
        StringBuilder res = new StringBuilder();

        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') {
                res.append(s.charAt(i));
            }
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
