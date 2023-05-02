package com.leetcode.demo.mar.day03;

public class StrConvert {

    public static void main(String[] args) {
        // 输入：s = "PAYPALISHIRING", numRows = 3
        //输出："PAHNAPLSIIGYIR"

        // 输入：s = "PAYPALISHIRING", numRows = 4
        //输出："PINALSIGYAHRPI"
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(s.length());
    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return s;
        char[][] matrix = new char[numRows][1];

        return null;
    }
}
