package com.leetcode.demo.easy.mar.mar_08;

import com.leetcode.demo.easy.feb.feb_01.FindOrder;

import java.util.*;

public class RemoveCoveredIntervals {

    public static void main(String[] args) {
        // 输入：intervals = [[1,4],[3,6],[2,8]]
        // {{1, 4}, {3, 6}, {2, 8}}
        //输出：2

        // [[3,10],[4,10],[5,11]]
        // {{3,10},{4,10},{5,11}}
        // 2

        // [[1,2],[1,4],[3,4]]
        // {{1,2},{1,4},{3,4}}
        // 1

        // [[66672,75156],[59890,65654],[92950,95965],[9103,31953],[54869,69855],[33272,92693],[52631,65356],[43332,89722],[4218,57729],[20993,92876]]
        // {{66672,75156},{59890,65654},{92950,95965},{9103,31953},{54869,69855},{33272,92693},{52631,65356},{43332,89722},{4218,57729},{20993,92876}}
        // 3
        int[][] intervals = {{1, 2}, {1, 4}, {3, 4}};
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals2(intervals));
    }

    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;
        int count = 1;

        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        }));
        printMatrix(intervals);

        int[] prePair = {intervals[0][0], intervals[0][1]};
        for (int i = 1; i < len; i++) {
            count++;
            int cur = intervals[i][0];
            int pre = prePair[0];
            if (cur == pre) {
                count--;
                prePair[1] = Math.max(prePair[1], intervals[i][1]);
            } else if (prePair[1] >= intervals[i][1]) {
                count--;
            } else {
                prePair[0] = intervals[i][0];
                prePair[1] = intervals[i][1];
            }
        }
        return count;
    }

    public int removeCoveredIntervals2(int[][] intervals) {
        int len = intervals.length;
        int count = 0;

        Arrays.sort(intervals, ((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));
        int end, preEnd = 0;
        for (int[] curArr : intervals) {
            end = curArr[1];
            if (preEnd < end) {
                preEnd = end;
                count++;
            }
        }
        return count;
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
