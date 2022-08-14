package com.leetcode.demo.aug_14;

import java.util.Arrays;

public class ConvertOfZ {

    public static void main(String[] args) {
        System.out.println("PAYPALISHIRING".length());
        System.out.println(new ConvertOfZ().convert("ABCDE", 4));
    }

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        int numOfArr = 2 * numRows - 2;
        int totalColumn = (s.length() + numOfArr - 1) / numOfArr * (numRows - 1);
        char[][] resMatrix = new char[numRows][totalColumn];
        for (int i = 0; i < numRows; i++) {
            Arrays.fill(resMatrix[i], '0');
        }
        int index = 0;
        int indexRow = 0, indexColumn = 0;
        while (indexColumn < totalColumn) {
            while (indexRow < numRows && index < s.length()) {
                resMatrix[indexRow][indexColumn] = s.charAt(index++);
                indexRow++;
            }
            if (index == s.length()) return accessMatrix(resMatrix);
            indexRow -= 2;
            while (indexRow > 0 && index < s.length()) {
                resMatrix[indexRow--][++indexColumn] = s.charAt(index++);
            }
            indexColumn++;
        }
        return accessMatrix(resMatrix);
    }

    public String accessMatrix(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar != '0') sb.append(aChar);
            }
        }
        return sb.toString();
    }

    public void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
