package com.leetcode.demo.easy.apr.apr_10;

public class AddBinary {

    public static void main(String[] args) {
        // 输入: a = "11", b = "1"
        //输出: "100"

        // 入: a = "1010", b = "1011"
        //输出: "10101"

        String a = "1010";
        String b = "1011";
        System.out.println(new AddBinary().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;

        int left = 0;

        while (index1 >= 0 || index2 >= 0) {
            int num1 = index1 < 0 ? 0 : a.charAt(index1) - '0';
            int num2 = index2 < 0 ? 0 : b.charAt(index2) - '0';

            int sum = num1 + num2 + left;
            sb.append(sum % 2);
            left = sum / 2;
            index1--;
            index2--;
        }
        if (left != 0) sb.append(left);
        return sb.reverse().toString();
    }
}
