package com.leetcode.demo.apr.day14;

import java.util.PriorityQueue;

public class PrimDemo {

    private static class Node {
        int from;
        int to;
        int weight;

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
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
        System.out.println("总长度为: " + prim(graph, 0));
    }

    public static int prim(int[][] graph, int start) {
        int nodes = graph.length;
        boolean[] visited = new boolean[nodes];
        visited[start] = true;
        int ans = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        for (int i = 0; i < nodes; i++) {
            if (graph[start][i] != 0) {
                queue.offer(new Node(start, i, graph[start][i]));
            }
        }

        int index = 0;
        while (index < nodes - 1) {
            Node tmpNode = null;
            while (true) {
                tmpNode = queue.poll();
                if (visited[tmpNode.to]) continue;
                break;
            }
            visited[tmpNode.to] = true;
            ans += tmpNode.weight;
            System.out.println("起点： " + tmpNode.from + " 终点： " + tmpNode.to + " 长度为:" + tmpNode.weight);
            for (int i = 0; i < nodes; i++) {
                if (graph[tmpNode.to][i] != 0 && !visited[i]) {
                    queue.offer(new Node(tmpNode.to, i, graph[tmpNode.to][i]));
                }
            }
            index++;
        }
        return ans;
    }
}
