package com.leetcode.demo.easy.apr.apr_30_2;

public class SearchMatrix {

    public static void main(String[] args) {
        // 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
        //输出：true

        // [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
        // false
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(new SearchMatrix().searchMatrix3(matrix, 6));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = n - 1;
        while (low < m && high >= 0) {
            if (matrix[low][high] == target) return true;
            else if (matrix[low][high] > target) {
                high--;
            } else low++;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = n - 1;
        int index = 0;
        while (index < m) {
            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[index][mid] == target) return true;
                else if (matrix[index][mid] > target) high = mid - 1;
                else low = mid + 1;
            }
            index++;
            low = 0;
            high = n - 1;
        }
        return false;
    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}
