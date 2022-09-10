package com.leetcode.demo.sep_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeSegment {

    static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }

    public static void main(String[] args) {
        // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        //输出：[[1,6],[8,10],[15,18]]

        // 输入：intervals = [[1,4],[4,5]]
        //输出：[[1,5]]

        // [[1,4],[2,3]]
        // {1,4}
        int[][] intervals = {{1, 4}, {2, 3}};
        MergeSegment segment = new MergeSegment();
        segment.printMatrix(segment.merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, new MyComparator());

        List<int[]> resList = new ArrayList<>();
        int[] pre = new int[2];
        pre[0] = intervals[0][0];
        pre[1] = intervals[0][1];
        resList.add(pre);

        int size = intervals.length;
        for (int i = 1; i < size; i++) {
            int[] cur = intervals[i];
            if (cur[0] > pre[1]) {
                resList.add(cur);
                pre = cur;
            } else {
                resList.remove(resList.size() - 1);
                pre[1] = Math.max(pre[1], cur[1]);
                resList.add(pre);
            }
        }
        return resList.toArray(new int[resList.size()][]);
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
