package com.leetcode.demo.easy.feb.feb_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountSubstrings {

    public static void main(String[] args) {
        // 输入：s = "abc"
        //输出：3
        //解释：三个回文子串: "a", "b", "c"
        StringBuilder sb1 = new StringBuilder();
        sb1.append("bc");
        System.out.println(sb1.reverse().toString());
        System.out.println(sb1.toString());
        System.out.println(sb1.reverse().toString().equals(sb1.toString()));
        sb1.reverse();
        System.out.println(new CountSubstrings().countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        return manacher(s);
    }

    public int manacher(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }

        int len = sb.length();
        int right = -1, j = -1;
        List<Integer> armList = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curArm;
            if (i > right) {
                curArm = expand(sb, i, i);
            } else {
                int symPoint = 2 * j - i;
                int minArm = Math.min(right - i, armList.get(symPoint));
                curArm = expand(sb, i - minArm, i + minArm);
            }
            armList.add(curArm);
            if (i + curArm > right) {
                right = i + curArm;
                j = i;
            }
            ans += (curArm + 1) / 2;
        }
        System.out.println(armList);
        return ans;
    }

    public int expand(StringBuilder sb, int left, int right) {
        while (left >= 0 && right < sb.length() && sb.charAt(left) == sb.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }

    public boolean isPalindromic(StringBuilder sb) {
        if (sb.length() == 0) return false;
        if (sb.length() == 1) return true;
        String temp = sb.toString();
        return sb.reverse().toString().equals(temp);
    }
}
