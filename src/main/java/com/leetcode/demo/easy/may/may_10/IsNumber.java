package com.leetcode.demo.easy.may.may_10;

import java.util.HashSet;
import java.util.Set;

public class IsNumber {

    public static void main(String[] args) {
        // 输入：s = "    .1  "
        //输出：true

        String s = ".2e81";
        System.out.println(new IsNumber().isNumber(s));
    }

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        int index = 0;
        s = s.trim();
        if (s.length() == 0) return false;
        boolean flagNum = false;
        int countOfPoints = 0, countOfPlus = 0, countOfNegative = 0;
        Set<Character> set = Set.of('.', 'e', 'E', '+', '-');
        while (index < s.length()) {
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                flagNum = true;
                index++;
            }
            if (index == s.length()) return true;
            if (!set.contains(s.charAt(index))) return false;
            boolean flag = false;
            if (s.charAt(index) == '.') {
                countOfPoints++;
                index++;
                if (countOfPoints > 1) return false;
                if (index == s.length()) return flagNum;
                if (s.charAt(index) == 'e') continue;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    flagNum = true;
                    flag = true;
                    index++;
                }
            } else if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                if (s.charAt(index) == '+') countOfPlus++;
                else countOfNegative++;
                index++;
                if (countOfNegative > 1 || countOfPlus > 1 || flagNum) return false;
                if (index == s.length()) return false;
                if (s.charAt(index) == '.') continue;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    flagNum = true;
                    flag = true;
                    index++;
                }
            } else if (s.charAt(index) == 'e' || s.charAt(index) == 'E') {
                if (!flagNum) return false;
                String temp = s.substring(index + 1);
                return isNum(temp);
            } else return false;
            if (!flag) return false;
        }
        return true;
    }

    public boolean isNum(String s) {
        int index = 0;
        if (s.length() == 0) return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') index++;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) index++;
            else return false;
            if (index == s.length()) return true;
        }
        return false;
    }
}
