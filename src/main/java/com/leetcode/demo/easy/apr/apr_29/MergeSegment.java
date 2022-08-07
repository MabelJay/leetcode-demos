package com.leetcode.demo.easy.apr.apr_29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSegment {

    public static void main(String[] args) {
        // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        //输出：[[1,6],[8,10],[15,18]]

        // 输入：intervals = [[1,4],[4,5]]
        //输出：[[1,5]]

        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr1 = {{1, 4}, {1, 5}};
        new MergeSegment().printMatrix(new MergeSegment().merge(arr));
    }

    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < m; i++) {
            int[] preArr = list.get(list.size() - 1);
            int[] tempArr = intervals[i];
            if (tempArr[0] > preArr[1]) {
                list.add(tempArr);
            } else if (tempArr[0] >= preArr[0] || tempArr[0] == preArr[1]) {
                list.remove(list.size() - 1);
                preArr[1] = Math.max(preArr[1], tempArr[1]);
                list.add(preArr);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // if (intervals.length == 0) {
    //            return new int[0][2];
    //        }
    //        Arrays.sort(intervals, new Comparator<int[]>() {
    //            public int compare(int[] interval1, int[] interval2) {
    //                return interval1[0] - interval2[0];
    //            }
    //        });
    //        List<int[]> merged = new ArrayList<int[]>();
    //        for (int i = 0; i < intervals.length; ++i) {
    //            int L = intervals[i][0], R = intervals[i][1];
    //            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
    //                merged.add(new int[]{L, R});
    //            } else {
    //                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
    //            }
    //        }
    //        return merged.toArray(new int[merged.size()][]);
}
