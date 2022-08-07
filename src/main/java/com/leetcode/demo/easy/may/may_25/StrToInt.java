package com.leetcode.demo.easy.may.may_25;

public class StrToInt {

    public static void main(String[] args) {
//        System.out.println(String.valueOf(Integer.MAX_VALUE).length());
//        System.out.println(String.valueOf(Integer.MIN_VALUE).length());

        System.out.println(new StrToInt().strToInt("  0000000000012345678"));
    }

    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        boolean isNegative = false;

        int index = 0;
        StringBuilder sb = new StringBuilder();
        char temp = str.charAt(index);
        if (temp == '+' || temp == '-' || Character.isDigit(temp)) {
            if (temp == '-') isNegative = true;
            if (temp == '+' || temp == '-') index++;
            while (index < str.length() && Character.isDigit(str.charAt(index))) {
                if (sb.length() == 0 && str.charAt(index) == '0') {
                    index++;
                    continue;
                }
                sb.append(str.charAt(index));
                index++;
            }
        } else return 0;

        if (sb.length() == 0) return 0;
        if (isNegative) {
            if (sb.length() > 10 || Long.parseLong(sb.toString()) > Integer.MAX_VALUE) return Integer.MIN_VALUE;
            return Integer.parseInt(sb.toString()) * -1;
        }
        if (sb.length() > 10 || Long.parseLong(sb.toString()) > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return Integer.parseInt(sb.toString());
    }
}
