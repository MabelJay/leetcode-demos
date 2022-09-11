package com.leetcode.demo.sep_11;

public class AddBinary {

    public static void main(String[] args) {
        // 输入: a = "11", b = "1"
        //输出: "100"


        // 输入: a = "1010", b = "1011"
        //输出: "10101"

        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }

        if (a.length() == 0 || b.length() == 0) {
            return a.length() == 0 ? b : a;
        }
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        while (index1 >= 0 || index2 >= 0 || left > 0) {
            int num1 = index1 < 0 ? 0 : a.charAt(index1) - '0';
            int num2 = index2 < 0 ? 0 : b.charAt(index2) - '0';
            int sum = num1 + num2 + left;
            sb.append(sum % 2);
            left = sum / 2;
            index1--;
            index2--;
        }

        return sb.reverse().toString();
    }
}
