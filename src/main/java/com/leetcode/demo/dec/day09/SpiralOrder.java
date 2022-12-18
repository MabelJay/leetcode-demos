package com.leetcode.demo.dec.day09;

import java.util.Arrays;

public class SpiralOrder {

    int index = 0;

    public static void main(String[] args) {
        // 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[1,2,3,6,9,8,7,4,5]

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        //输出：[1,2,3,4,8,12,11,10,9,5,6,7]

        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(new SpiralOrder().spiralOrder(matrix2)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] resArr = new int[rows * columns];

        int start = 0;
        while (rows > start * 2 && columns > start * 2) {
            getMatrixOrder(matrix, rows, columns, start, resArr);
            start++;
        }
        return resArr;
    }

    public void getMatrixOrder(int[][] matrix, int rows, int columns, int start, int[] resArr) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        for (int i = start; i <= endX; i++) {
            resArr[index++] = matrix[start][i];
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                resArr[index++] = matrix[i][endX];
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                resArr[index++] = matrix[endY][i];
            }
        }

        if (start < endX && start < endY) {
            for (int i = endY - 1; i > start; i--) {
                resArr[index++] = matrix[i][start];
            }
        }
    }
}
