package com.leetcode.demo.easy.feb.feb_07;

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

        System.out.println(sb);
        s = sb.toString();

        int start = 0, end = -1;
        int j = -1, right = -1;

        List<Integer> armList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int curArm;
            if (i > right) {
                curArm = expandArm(s, i, i);
            } else {
                int symPoint = 2 * j - i;
                int minArm = Math.min(armList.get(symPoint), right - i);
                curArm = expandArm(s, i - minArm, i + minArm);
            }
            armList.add(curArm);

            if (i + curArm > right) {
                j = i;
                right = curArm + i;
            }

            if (2 * curArm + 1 > end - start) {
                start = i - curArm;
                end = i + curArm;
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

    public static int expandArm(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return (right - left - 2) / 2;
    }
}
