package com.leetcode.demo.dec.day09;

import java.util.ArrayList;
import java.util.List;

public class PrintSeqMatrix {

    public static void main(String[] args) {
        // 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[1,2,3,6,9,8,7,4,5]

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new PrintSeqMatrix().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;

        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            // print matrix in circle
            printMatrixCircle(matrix, start, rows, columns, list);
            start++;
        }
        return list;
    }

    public void printMatrixCircle(int[][] matrix, int start, int rows, int columns, List<Integer> list) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        for (int i = start; i <= endX; i++) {
            int number = matrix[start][i];
            list.add(number);
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int number = matrix[i][endX];
                list.add(number);
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int number = matrix[endY][i];
                list.add(number);
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                int number = matrix[i][start];
                list.add(number);
            }
        }
    }
}
