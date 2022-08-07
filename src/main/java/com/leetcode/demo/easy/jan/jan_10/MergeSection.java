package com.leetcode.demo.easy.jan.jan_10;

import java.util.*;

public class MergeSection {

    public static class Pair implements Comparator<Pair> {
        int start;
        int end;

        private Pair() {

        }

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.start - o2.start;
        }
    }

    public static void main(String[] args) {
        // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        //输出：[[1,6],[8,10],[15,18]]`
        //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

        // [[1,4],[0,4]]`
        // [[2,3],[4,5],[6,7],[8,9],[1,10]]`
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // }}1,3],}2,6],[8,10],[15,18]]
        printMatrix(new MergeSection().merge2(intervals));
    }

    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        List<Pair> list = new ArrayList<>();
        List<Pair> resList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new Pair(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list, new Pair());

        Pair firstPair = list.get(0);
        for (int i = 1; i < m; i++) {
            if (list.get(i).start > firstPair.end) {
                resList.add(firstPair);
                firstPair = new Pair(list.get(i).start, list.get(i).end);
            } else if (list.get(i).end < firstPair.start) {
                resList.add(new Pair(list.get(i).start, list.get(i).end));
            } else {
                firstPair.start = Math.min(list.get(i).start, firstPair.start);
                firstPair.end = Math.max(firstPair.end, list.get(i).end);
            }
        }
        resList.add(firstPair);
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i][0] = resList.get(i).start;
            res[i][1] = resList.get(i).end;
        }
        return res;
    }

    public static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();
        int m = intervals.length;
        int s1 = intervals[0][0], e1 = intervals[0][1];
        for (int i = 1; i < m; i++) {
            if (intervals[i][0] > e1) {
                merged.add(new int[]{s1, e1});
                s1 = intervals[i][0];
                e1 = intervals[i][1];
            } else {
                e1 = Math.max(e1, intervals[i][1]);
            }
        }
        merged.add(new int[]{s1, e1});
        return merged.toArray(new int[merged.size()][]);
    }
}
