package com.leetcode.demo.easy;

public class AddString {

    public static void main(String[] args) {
        // 输入：num1 = "11", num2 = "123"
        //输出："134"
//        System.out.println('2' - 48 + '2' - 48);
        System.out.println(new AddString().addStrings("9", "99"));
    }

    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int left = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {
            int tmp1 = 0, tmp2 = 0;
            if (index1 >= 0) {
                tmp1 = num1.charAt(index1) - 48;
            }
            if (index2 >= 0) {
                tmp2 = num2.charAt(index2) - 48;
            }
            sb.append((tmp1 + tmp2 + left) % 10);
            left = (tmp1 + tmp2 + left) / 10;
            index1--;
            index2--;
        }
        if (left > 0) sb.append(left);
        return sb.reverse().toString();
    }
}
