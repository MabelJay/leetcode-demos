package com.leetcode.demo.easy.apr.apr_12;

import java.util.Arrays;

public class FindDiagonalOrder {
    public static void main(String[] args) {
        // 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[1,2,4,7,5,3,6,8,9]

        // 输入：mat = [[1,2],[3,4]]
        //输出：[1,2,3,4]

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // 输入：mat = [[1,2],[3,4]]
        //输出：[1,2,3,4]

        int[][] mat2 = {{1, 2}, {3, 4}};
        System.out.println(Arrays.toString(new FindDiagonalOrder().findDiagonalOrder(mat2)));
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] res = new int[m * n];
        int row = 0, column = 0;
        int index = 0;
        boolean flag = true;
        while (index < m * n) {
            if (flag) {
                if (row == m) {
                    row--;
                    column++;
                }
                while (row >= 0 && column < n) {
                    res[index++] = mat[row][column];
                    row--;
                    column++;
                }
                row++;
                flag = false;
            } else {
                if (column == n) {
                    column--;
                    row++;
                }
                while (column >= 0 && row < m) {
                    res[index++] = mat[row][column];
                    row++;
                    column--;
                }
                column++;
                flag = true;
            }
        }
        return res;
    }
}
