package com.leetcode.demo.easy.apr.apr_19;

import java.util.ArrayList;
import java.util.List;

public class Manacher {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(manacher(s));
    }

    public static String manacher(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        s = sb.toString();
        System.out.println(s);

        int j = -1, right = -1;
        int start = 0, end = -1;

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

        StringBuilder res = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static int expandArm(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }
}
