package com.leetcode.demo.interview.graph;

import java.util.PriorityQueue;

public class PrimDemo {

    private static class GraphEdge {
        int from;
        int to;
        int weight;

        GraphEdge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 6, 1, 5, 0, 0},
                {6, 0, 5, 0, 3, 0},
                {1, 5, 0, 5, 6, 4},
                {5, 0, 5, 0, 0, 2},
                {0, 3, 6, 0, 0, 6},
                {0, 0, 4, 2, 6, 0}};

        System.out.println("final result is: " + prim(graph, 0));
    }

    private static int prim(int[][] graph, int start) {
        if (graph == null || graph.length == 0) return 0;

        int nodeCount = graph.length;
        boolean[] visited = new boolean[nodeCount];
        PriorityQueue<GraphEdge> queue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        for (int i = 0; i < nodeCount; i++) {
            if (graph[start][i] != 0) {
                queue.offer(new GraphEdge(start, i, graph[start][i]));
            }
        }

        visited[start] = true;
        int ans = 0;
        for (int i = 0; i < nodeCount - 1; i++) {
            GraphEdge tmpNode = null;
            while (!queue.isEmpty()) {
                tmpNode = queue.poll();
                if (visited[tmpNode.to]) continue;
                break;
            }
            if (tmpNode == null) throw new RuntimeException("Not a connection graph");
            ans += tmpNode.weight;
            visited[tmpNode.to] = true;
            System.out.println("起点： " + tmpNode.from + " 终点：" + tmpNode.to + " 长度为:" + tmpNode.weight);

            for (int j = 0; j < nodeCount; j++) {
                if (visited[j]) continue;
                if (graph[tmpNode.to][j] != 0) {
                    queue.offer(new GraphEdge(tmpNode.to, j, graph[tmpNode.to][j]));
                }
            }
        }
        return ans;
    }
}
