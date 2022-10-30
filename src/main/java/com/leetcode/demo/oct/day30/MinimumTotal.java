package com.leetcode.demo.oct.day30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MinimumTotal {
    public static void main(String[] args) {
        // 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        //输出：11

        // [[-1],[2,3],[1,-1,-3]]
        //-1

        List<List<Integer>> list = new ArrayList<>();
        int[][] arr = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        MinimumTotal minimumTotal = new MinimumTotal();
        minimumTotal.getList(list, arr);
//        System.out.println(list);
        System.out.println(minimumTotal.minimumTotal(list));
    }

    public void getList(List<List<Integer>> list, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                tmpList.add(arr[i][j]);
            }
            list.add(tmpList);
        }
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int size = triangle.size();

        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            min = Math.min(min, dp[size - 1][i]);
        }
        return min;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
