package com.leetcode.demo.easy.june.june_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergSeg {

    public static void main(String[] args) {
        // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        //输出：[[1,6],[8,10],[15,18]]
        //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

        int[][] intervals = {{1, 3}, {1, 5}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr = new MergSeg().merge(intervals);
        new MergSeg().printMatrix(arr);
    }

    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        }));

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < m; i++) {
            int[] lastSeg = list.get(list.size() - 1);
            int end = lastSeg[1];
            int start = lastSeg[0];
            if (end < intervals[i][0]) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                list.remove(list.size() - 1);
                list.add(new int[]{start, Math.max(end, intervals[i][1])});
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
