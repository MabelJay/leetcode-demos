package com.leetcode.demo.apr.day13;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimDemo2 {

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
        int nodes = graph.length;
        boolean[] visited = new boolean[nodes];
        visited[start] = true;

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int ans = 0;
        for (int i = 0; i < nodes; i++) {
            if (graph[start][i] != 0) {
                queue.offer(new Integer[]{graph[start][i], start, i});
            }
        }
        for (int i = 0; i < nodes - 1; i++) {
            Integer[] temp = null;
            while (!queue.isEmpty()) {
                temp = queue.poll();
                if (visited[temp[2]]) continue;
                break;
            }
            visited[temp[2]] = true;
            ans += temp[0];
            System.out.println("起点： " + temp[1] + " 终点：" + temp[2] + " 长度为：" + temp[0]);
            for (int j = 0; j < nodes; j++) {
                if (graph[temp[2]][j] != 0 && !visited[j]) {
                    queue.offer(new Integer[]{graph[temp[2]][j], temp[2], j});
                }
            }
        }
        return ans;
    }
}
