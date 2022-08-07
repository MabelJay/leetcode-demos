package com.leetcode.demo.easy;

public class MatrixReshape {
    public static void main(String[] args) {
        // 输入：mat = [[1,2],[3,4]], r = 2, c = 4
        //输出：[[1,2],[3,4]]

        // [[1,2],[3,4]]
        //2  4
        //[[1,2],[3,4]]

        //[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16],[17,18,19,20]]
        //42
        //5

        //[[1,2,3,4,5,6],[7,8,9,10,11,12],[13,14,15,16,17,18],[19,20,21,22,23,24],[25,26,27,28,29,30]]
        //22
        //15

        int[][] mat = new int[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}};

        MatrixReshape reshape = new MatrixReshape();
        reshape.printMatrix(reshape.matrixReshape(mat, 22, 15));
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int size = m * n;
        int newSize = c * r;
        if (size > newSize || size % (newSize) != 0 || size < r) return mat;
        int column = (size) / r;
        int[][] newMat = new int[r][column];
        int rIndex = 0, cIndex = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cIndex == column) {
                    cIndex = 0;
                    rIndex++;
                }
                newMat[rIndex][cIndex] = mat[i][j];
                cIndex++;
            }
        }
        return newMat;
    }

    public void printMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
