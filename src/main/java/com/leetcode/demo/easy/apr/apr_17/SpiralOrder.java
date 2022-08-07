package com.leetcode.demo.easy.apr.apr_17;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {
        // 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[1,2,3,6,9,8,7,4,5]
        // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new SpiralOrder().spiralOrder(matrix));

        // 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        //输出：[1,2,3,4,8,12,11,10,9,5,6,7]
        // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7, 6]
        // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new SpiralOrder().spiralOrder(matrix2));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rowVisited = new boolean[m];
        boolean[] columnVisited = new boolean[n];

        List<Integer> list = new ArrayList<>();
        int rowIndex = 0;
        int columnIndex = 0;
        int count = 0;
        while (count < m * n) {
            while (columnIndex < n && !columnVisited[columnIndex] && !rowVisited[rowIndex]) {
                list.add(matrix[rowIndex][columnIndex++]);
                count++;
            }
            rowVisited[rowIndex++] = true;
            columnIndex--;
            while (rowIndex < m && !rowVisited[rowIndex] && !columnVisited[columnIndex]) {
                list.add(matrix[rowIndex][columnIndex]);
                count++;
                rowIndex++;
            }
            columnVisited[columnIndex--] = true;
            rowIndex--;
            while (columnIndex >= 0 && !columnVisited[columnIndex] && !rowVisited[rowIndex]) {
                list.add(matrix[rowIndex][columnIndex--]);
                count++;
            }
            rowVisited[rowIndex--] = true;
            columnIndex++;
            while (rowIndex >= 0 && !rowVisited[rowIndex] && !columnVisited[columnIndex]) {
                list.add(matrix[rowIndex--][columnIndex]);
                count++;
            }
            columnVisited[columnIndex++] = true;
            rowIndex++;
        }
        return list;
    }
}
