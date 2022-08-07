package com.leetcode.demo.easy.jan.jan_13;

public class SearchMatrix {

    public static void main(String[] args) {
        // 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        //输出：true

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(new SearchMatrix().searchMatrix(matrix, 3));

    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row1 = 0, row2 = m - 1;
        int queue1 = 0, queue2 = n - 1;
        while (row1 <= row2 && queue1 <= queue2) {
            int mid = matrix[(row2 + row1) / 2][(queue1 + queue2) / 2];
            if (mid == target) return true;
            else if (mid < target) {
                queue1++;
                if (queue1 > n - 1) {
                    queue1 = 0;
                    row1++;
                }
            } else {
                queue2--;
                if (queue2 < 0) {
                    row2--;
                    queue2 = n - 1;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            int x = matrix[mid / n][mid % n];
            if (x == target) return true;
            else if (x > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
