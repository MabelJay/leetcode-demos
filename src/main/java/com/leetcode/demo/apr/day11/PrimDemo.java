package com.leetcode.demo.apr.day11;

import java.util.ArrayList;
import java.util.List;

public class PrimDemo {

    public static void main(String[] args) {
        int[][] graph =
                {{0, 6, 1, 5, 0, 0},
                        {6, 0, 5, 0, 3, 0},
                        {1, 5, 0, 5, 6, 4},
                        {5, 0, 5, 0, 0, 2},
                        {0, 3, 6, 0, 0, 6},
                        {0, 0, 4, 2, 6, 0}};

        System.out.println(prim(graph, 0));
    }

    private static int prim(int[][] graph, int start) {
        int ans = 0;
        int nodeCount = graph.length;
        boolean[] visited = new boolean[nodeCount];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nodeCount - 1; i++) {
            list.add(start);
            visited[start] = true;
            int minVal = Integer.MAX_VALUE;

            for (int row : list) {
                for (int j = 0; j < nodeCount; j++) {
                    if (!visited[j]) {
                        if (graph[row][j] < minVal && graph[row][j] > 0) {
                            start = j;
                            minVal = graph[row][j];
                        }
                    }
                }
            }
            ans += minVal;
        }
        return ans;
    }
}
