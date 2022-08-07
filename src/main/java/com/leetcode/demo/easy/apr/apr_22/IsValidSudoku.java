package com.leetcode.demo.easy.apr.apr_22;

import java.util.Arrays;

public class IsValidSudoku {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        int len = 9;
        int[] validArr = new int[len];
        int[] validArr2 = new int[len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(validArr, 0);
            Arrays.fill(validArr2, 0);
            for (int j = 0; j < len; j++) {
                if (Character.isDigit(board[i][j])) {
                    int index1 = board[i][j] - '1';
                    System.out.println("index1=" + index1);
                    validArr[index1]++;
                    if (validArr[index1] > 1) return false;
                }
                if (Character.isDigit(board[j][i])) {
                    int index2 = board[j][i] - '1';
                    System.out.println("index2=" + index2);
                    validArr2[index2]++;
                    if (validArr2[index2] > 1) return false;
                }
            }
            System.out.println(Arrays.toString(validArr));
        }

        for (int i = 0; i < len - 2; i += 3) {
            for (int j = 0; j < len - 2; j += 3) {
                Arrays.fill(validArr, 0);
                for (int k1 = i; k1 < i + 3; k1++) {
                    for (int k2 = j; k2 < j + 3; k2++) {
                        if (Character.isDigit(board[k1][k2])) {
                            int index = board[k1][k2] - '1';
                            validArr[index]++;
                            if (validArr[index] > 1) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
