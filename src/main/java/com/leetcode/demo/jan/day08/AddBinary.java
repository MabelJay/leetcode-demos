package com.leetcode.demo.jan.day08;

public class AddBinary {

    public static void main(String[] args) {
        // 输入: a = "11", b = "10"
        //输出: "101"

        // 输入: a = "1010", b = "1011"
        //输出: "10101"

        String a = "11";
        String b = "10";
        System.out.println(new AddBinary().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        int left = 0;
        StringBuilder sb = new StringBuilder();
        int len1 = a.length();
        int len2 = b.length();
        int index1 = len1 - 1;
        int index2 = len2 - 1;
        int sum = 0;

        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                sum = b.charAt(index2) - '0' + left;
            } else if (index2 < 0) {
                sum = a.charAt(index1) - '0' + left;
            } else {
                sum = a.charAt(index1) - '0' + b.charAt(index2) - '0' + left;
            }
            index1--;
            index2--;
            sb.append(sum % 2);
            left = sum / 2;
        }
        if (left > 0) {
            sb.append(left);
        }
        return sb.reverse().toString();
    }
}
