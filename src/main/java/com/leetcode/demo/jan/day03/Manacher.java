package com.leetcode.demo.jan.day03;

import java.util.ArrayList;
import java.util.List;

public class Manacher {

    public static void main(String[] args) {
        String s = "abcbd";
        System.out.println(manacher(s));
    }

    public static String manacher(String s) {
        if (s == null || s.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        sb.append("#");

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        s = sb.toString();
        System.out.println("s=" + s);

        List<Integer> armList = new ArrayList<>();
        int start = 0, end = -1;
        int j = -1, right = -1;

        for (int i = 0; i < s.length(); i++) {
            int cur;
            if (i >= right) {
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

            if (i + cur > right) {
                right = i + cur;
                j = i;
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

    public static int expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return (j - i - 2) / 2;
    }
}
