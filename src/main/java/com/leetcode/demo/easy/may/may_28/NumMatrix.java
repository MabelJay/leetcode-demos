package com.leetcode.demo.easy.may.may_28;

class NumMatrix {

    int[][] matrix;
    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        preSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    preSum[i][j] = matrix[i][j];
                } else preSum[i][j] = preSum[i][j - 1] + matrix[i][j];
            }
        }
        printMatrix(preSum);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 > 0) {
                sum += preSum[i][col2] - preSum[i][col1 - 1];
            } else {
                sum += preSum[i][col2];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // ["NumMatrix","sumRegion","sumRegion","sumRegion"]
        //[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
        // [null, 8, 11, 12]

        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);

        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}