package com.leetcode.demo.mar.day02;

public class StrToInt {

    public static void main(String[] args) {
        String str = "0000000000012345678";

        // str =
        //"+1"
        System.out.println(new StrToInt().strToInt(str));
    }

    public int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;

        int index = 0;
        int len = str.length();
        boolean isNegative = false;
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        if (index == len) return 0;
        StringBuilder sb = new StringBuilder();
        if (str.charAt(index) == '-') {
            isNegative = true;
            index++;
        } else if (str.charAt(index) == '+') index++;
        while (index < len && Character.isDigit(str.charAt(index))) {
            if (sb.length() == 0 && str.charAt(index) == '0') {
                index++;
                continue;
            }
            sb.append(str.charAt(index));
            index++;
        }
        if (sb.length() > 0) {
            if (sb.length() > 10) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            long res = Long.parseLong(sb.toString());
            if (isNegative) {
                res = -1 * res;
                return res < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) res;
            } else {
                return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
            }
        }
        return 0;
    }
}
