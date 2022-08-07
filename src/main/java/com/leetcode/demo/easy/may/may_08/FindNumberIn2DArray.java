package com.leetcode.demo.easy.may.may_08;

public class FindNumberIn2DArray {

    public static void main(String[] args) {
        // [
        //  [1,   4,  7, 11, 15],
        //  [2,   5,  8, 12, 19],
        //  [3,   6,  9, 16, 22],
        //  [10, 13, 14, 17, 24],
        //  [18, 21, 23, 26, 30]
        //]
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return true;
        int n = matrix[0].length;
        int m = matrix.length;

        for (int i = 0; i < m; i++) {
            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[i][mid] == target) return true;
                else if (matrix[i][mid] > target) high = mid - 1;
                else low = mid + 1;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = 0, column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) return true;
            else if (matrix[row][column] > target) column--;
            else row++;
        }
        return false;
    }
}
