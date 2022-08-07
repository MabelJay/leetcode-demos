package com.leetcode.demo.easy.may.may_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {
        // 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[1,2,3,6,9,8,7,4,5]

        // 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        //输出：[1,2,3,4,8,12,11,10,9,5,6,7]

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix2 = {{3}, {2}};
        System.out.println(Arrays.toString(new SpiralOrder().spiralOrder(matrix2)));
        System.out.println(new SpiralOrder().spiralOrder2(matrix2));
    }

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;

        int[] res = new int[m * n];
        boolean[] rowVisited = new boolean[m];
        boolean[] columnVised = new boolean[n];
        int row = 0, column = 0;
        int index = 0;
        while (index < m * n) {
            // move right
            while (index < m * n && column < n && !columnVised[column]) {
                res[index++] = matrix[row][column];
                column++;
            }
            rowVisited[row] = true;
            column--;
            row++;
            // move down
            while (index < m * n && row < m && !rowVisited[row]) {
                res[index++] = matrix[row][column];
                row++;
            }
            columnVised[column] = true;
            row--;
            column--;
            // move left
            while (index < m * n && column >= 0 && !columnVised[column]) {
                res[index++] = matrix[row][column];
                column--;
            }
            rowVisited[row] = true;
            column++;
            row--;

            // move up
            while (index < m * n && row > 0 && !rowVisited[row]) {
                res[index++] = matrix[row][column];
                row--;
            }
            columnVised[column] = true;
            row++;
            column++;
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return list;
        int n = matrix[0].length;

        boolean[] rowVisited = new boolean[m];
        boolean[] columnVised = new boolean[n];
        int row = 0, column = 0;
        while (list.size() < m * n) {
            // move right
            while (list.size() < m * n && column < n && !columnVised[column]) {
                list.add(matrix[row][column]);
                column++;
            }
            rowVisited[row] = true;
            column--;
            row++;
            // move down
            while (list.size() < m * n && row < m && !rowVisited[row]) {
                list.add(matrix[row][column]);
                row++;
            }
            columnVised[column] = true;
            row--;
            column--;
            // move left
            while (list.size() < m * n && column >= 0 && !columnVised[column]) {
                list.add(matrix[row][column]);
                column--;
            }
            rowVisited[row] = true;
            column++;
            row--;

            // move up
            while (list.size() < m * n && row > 0 && !rowVisited[row]) {
                list.add(matrix[row][column]);
                row--;
            }
            columnVised[column] = true;
            row++;
            column++;
        }
        return list;
    }
}
