package com.leetcode.demo.apr.day13;

import java.util.PriorityQueue;

public class PrimFinal {

    private static class QueueNode {
        int weight;
        int from;
        int to;

        QueueNode(int weight, int from, int to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

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
        int nodes = graph.length;
        PriorityQueue<QueueNode> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (graph[start][i] != 0) {
                queue.offer(new QueueNode(graph[start][i], start, i));
            }
        }
        visited[start] = true;

        int ans = 0;
        for (int i = 0; i < nodes - 1; i++) {
            QueueNode node = null;
            while (!queue.isEmpty()) {
                node = queue.poll();
                if (visited[node.to]) continue;
                break;
            }
            if (node == null) throw new IllegalArgumentException("not a connection graph");
            visited[node.to] = true;
            System.out.println("起点： " + node.from + " 终点：" + node.to + " 长度为：" + node.weight);
            ans += node.weight;
            for (int j = 0; j < nodes; j++) {
                if (!visited[j] && graph[node.to][j] != 0) {
                    queue.offer(new QueueNode(graph[node.to][j], node.to, j));
                }
            }
        }
        return ans;
    }
}
