package com.leetcode.demo.easy.apr.apr_10;

public class ConvertStrWithZ {

    public static void main(String[] args) {
        // 输入：s = "PAYPALISHIRING", numRows = 3
        //输出："PAHNAPLSIIGYIR"
        // PAHNAPLSIIGYIR
        //PAHNAPLSIIGYIR

        // PINALSIGYAHRPI
        //PINALSIGYAHRPI
        // PINALSIGYAHRPI
        String s = "PAYPALISHIRING";
        String s2 = "A";
//        System.out.println(s.length());
        System.out.println(new ConvertStrWithZ().convert2(s, 4));
    }

    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1 || s.length() <= numRows) return s;
        int numColumns = 0;
        int len = s.length();
        int left = len;
        int temp = 0;
        while (left > 0) {
            while (left > 0 && temp < numRows) {
                left--;
                temp++;
            }
            numColumns++;
            temp = numRows - 2;
            while (left > 0 && temp > 0) {
                temp--;
                left--;
                numColumns++;
            }
        }
        System.out.println(numColumns);

        char[][] res = new char[numRows][numColumns];

        int row = 0, column = 0;
        int index = 0;
        while (index < len) {
            while (row < numRows && index < len) {
                res[row][column] = s.charAt(index++);
                row++;
            }
            row = numRows - 2;
            while (row > 0 && index < len) {
                res[row][++column] = s.charAt(index++);
                row--;
            }
            column++;
        }
        printMatrix(res);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (res[i][j] != 0) {
                    sb.append(res[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String convert2(String s, int numRows) {
        if (s.length() == 1 || numRows == 1 || s.length() <= numRows) return s;
        int t = 2 * numRows - 2;
        int len = s.length();
        int numColumns = (len + t - 1) / t * (numRows - 1);
        char[][] res = new char[numRows][numColumns];

        int row = 0, column = 0;
        int index = 0;
        while (index < len) {
            while (row < numRows && index < len) {
                res[row][column] = s.charAt(index++);
                row++;
            }
            row = numRows - 2;
            while (row > 0 && index < len) {
                res[row][++column] = s.charAt(index++);
                row--;
            }
            column++;
        }
        printMatrix(res);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (res[i][j] != 0) {
                    sb.append(res[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
