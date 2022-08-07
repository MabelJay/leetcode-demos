package com.leetcode.demo.easy.may.may_28;

public class AddBinary {

    public static void main(String[] args) {
        // 输入: a = "1010", b = "1011"
        //输出: "10101"

        // "1"
        //"111"

        // "101111"
        //"10"
        System.out.println(new AddBinary().addBinary2("101111", "10"));
    }

    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();

        int index1 = len1 - 1;
        int index2 = len2 - 1;
        int left = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                sum = b.charAt(index2) - '0' + left;
            } else if (index2 < 0) {
                sum = a.charAt(index1) - '0' + left;
            } else {
                sum = a.charAt(index1) - '0' + b.charAt(index2) - '0' + left;
            }
            sb.append(sum % 2);
            left = sum / 2;
            index1--;
            index2--;
        }
        if (left > 0) sb.append(left);
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        int left = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {
            left += index1 >= 0 ? a.charAt(index1) - '0' : 0;
            left += index2 >= 0 ? b.charAt(index2) - '0' : 0;
            sb.append(left % 2);
            left = left / 2;
            index2--;
            index1--;
        }
        if (left > 0) sb.append(left);
        return sb.reverse().toString();
    }
}
