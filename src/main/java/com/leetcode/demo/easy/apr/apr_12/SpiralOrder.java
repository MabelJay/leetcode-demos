package com.leetcode.demo.easy.apr.apr_12;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {
        // 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[1,2,3,6,9,8,7,4,5]
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowVisited = new boolean[m];
        boolean[] columnVisited = new boolean[n];

        List<Integer> resList = new ArrayList<>();
        int count = 0;
        int row = 0, column = 0;
        while (count < m * n) {
            while (column < n && !columnVisited[column]) {
                resList.add(matrix[row][column]);
                count++;
            }
            rowVisited[row] = true;
            column--;
            while (row < m && !rowVisited[row]) {
                resList.add(matrix[row][column]);
                row++;
            }
            columnVisited[column] = true;
            row--;
        }

        return resList;
    }
}
