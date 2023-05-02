package com.leetcode.demo.apr.day13;

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

    public static int prim(int[][] graph, int start) {
        int ans = 0;
        int allNodes = graph.length;
        boolean[] visited = new boolean[allNodes];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < allNodes - 1; i++) {
            visited[start] = true;
            list.add(start);

            int minVal = Integer.MAX_VALUE;

            for (int row : list) {
                for (int j = 0; j < allNodes; j++) {
                    if (!visited[j] && graph[row][j] > 0 && graph[row][j] < minVal) {
                        minVal = graph[row][j];
                        start = j;
                    }
                }

            }
            ans += minVal;
        }
        return ans;
    }
}
