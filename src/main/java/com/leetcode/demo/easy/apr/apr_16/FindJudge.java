package com.leetcode.demo.easy.apr.apr_16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindJudge {

    public static void main(String[] args) {
        // 输入：n = 2, trust = [[1,2]]
        //输出：2

        // 输入：n = 3, trust = [[1,3],[2,3]]
        //输出：3

        // 输入：n = 3, trust = [[1,3],[2,3],[3,1]]
        //输出：-1

        // 4
        //[[1,3],[1,4],[2,3],[2,4],[4,3]]

        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(new FindJudge().findJudge2(4, trust));
    }

    public int findJudge(int n, int[][] trust) {
        int m = trust.length;
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            arr[trust[i][1] - 1]++;
            set.add(trust[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == n - 1 && !set.contains(i + 1)) {
                return i + 1;
            }
        }
        return -1;
    }

    public int findJudge2(int n, int[][] trust) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        for (int[] ints : trust) {
            inDegree[ints[1] - 1]++;
            outDegree[ints[0] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) return i + 1;
        }
        return -1;
    }
}
