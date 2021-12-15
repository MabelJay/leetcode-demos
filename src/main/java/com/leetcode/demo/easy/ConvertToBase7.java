package com.leetcode.demo.easy;

public class ConvertToBase7 {

    public static void main(String[] args) {
//        System.out.println((long) Integer.MIN_VALUE * -1);
        System.out.println(new ConvertToBase7().convertToBase7(8));
    }

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean negative = false;
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            negative = true;
            num *= -1;
        }
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (negative) sb.append("-");
        return sb.reverse().toString();
    }
}
