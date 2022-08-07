package com.leetcode.demo.easy.may.may_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContinuousSequence {

    public static void main(String[] args) {
        // 输入：target = 9
        //输出：[[2,3,4],[4,5]]

        // 输入：target = 15
        //输出：[[1,2,3,4,5],[4,5,6],[7,8]]

        new FindContinuousSequence().findContinuousSequence2(9);
    }

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> resList = new ArrayList<>();

        int left = 1, right = 1;
        int sum = 1;
        while (left <= right) {
            while (sum < target) {
                right++;
                sum += right;
            }
            if (sum == target && right - left > 0) {
                List<Integer> tmpList = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    tmpList.add(i);
                }
                resList.add(tmpList);
            }
            sum -= left;
            left++;
        }
        System.out.println(resList);
        int[][] resArr = new int[resList.size()][];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = new int[resList.get(i).size()];
            int index = 0;
            for (int val : resList.get(i)) {
                resArr[i][index++] = val;
            }
        }
        return resArr;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] findContinuousSequence2(int target) {
        List<int[]> resList = new ArrayList<>();

        int left = 1, right = 1;
        int sum = 1;
        while (left <= right) {
            while (sum < target) {
                right++;
                sum += right;
            }

            if (sum == target && right - left > 0) {
                int[] arr = new int[right - left + 1];
                int index = 0;
                for (int i = left; i <= right; i++) {
                    arr[index++] = i;
                }
                resList.add(arr);
            }
            sum -= left;
            left++;
        }
        return resList.toArray(new int[resList.size()][]);
    }
}
