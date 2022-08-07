package com.leetcode.demo.easy.feb.feb_24;

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
        List<Integer> armList = new ArrayList<>();
        int j = -1, right = -1;
        int start = 0, end = -1;

        for (int i = 0; i < s.length(); i++) {
            int curArm;
            if (i > right) {
                curArm = expand(s, i, i);
            } else {
                int symPoint = 2 * j - i;
                int minArm = Math.min(armList.get(symPoint), right - i);
                curArm = expand(s, i - minArm, i + minArm);
            }

            armList.add(curArm);

            if (i > right) {
                right = i + curArm;
                j = i;
            }

            if (2 * curArm + 1 > end - start) {
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

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }
}
