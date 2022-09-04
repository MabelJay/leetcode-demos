package com.leetcode.demo.sep_04;

import java.util.Arrays;

public class IsValidSudoku {

    public static void main(String[] args) {
    }

    public boolean isValidSudoku2(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subBoxes = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int index = c - '1';
                rows[i][index]++;
                columns[j][index]++;
                subBoxes[i / 3][j / 3][index]++;
                if (rows[i][index] > 1 || columns[j][index] > 1 || subBoxes[i / 3][j / 3][index] > 1) return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        int[] arr = new int[9];
        for (char[] chars : board) {
            Arrays.fill(arr, 0);
            for (int j = 0; j < columns && chars[j] != '.'; j++) {
                int tmpIndex = chars[j] - '1';
                System.out.println("char=" + chars[j] + " index=" + tmpIndex);
                if (arr[tmpIndex] > 0) return false;
                arr[tmpIndex]++;
            }
        }

        for (int i = 0; i < columns; i++) {
            Arrays.fill(arr, 0);
            for (char[] chars : board) {
                if (chars[i] == '.') continue;
                int tmpIndex = chars[i] - '1';
                if (arr[tmpIndex] > 0) return false;
                arr[tmpIndex]++;
            }
        }

        for (int i = 0; i < rows; ) {
            if (i % 3 == 0) {
                for (int j = 0; j < columns; j++) {
                    int k = i;
                    if (j % 3 == 0) {
                        Arrays.fill(arr, 0);
                    }
                    while (k < i + 3) {
                        if (board[k][j] == '.') {
                            k++;
                            continue;
                        }
                        int index = board[k][j] - '1';
                        if (arr[index] > 0) return false;
                        arr[index]++;
                        k++;
                    }
                }
                i += 3;
            }
        }
        return true;
    }
}
