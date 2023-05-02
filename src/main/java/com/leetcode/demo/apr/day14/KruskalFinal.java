package com.leetcode.demo.apr.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KruskalFinal {

    static int[] parent;
    static int[] rank;
    static List<Node> list = new ArrayList<>();
    private static int ans = 0;

    private static class Node implements Comparable<Node> {
        int from;
        int to;
        int weight;

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        int[][] graph =
                {{0, 6, 1, 5, 0, 0},
                        {0, 0, 5, 0, 3, 0},
                        {0, 0, 0, 5, 6, 4},
                        {0, 0, 0, 0, 0, 2},
                        {0, 0, 0, 0, 0, 6},
                        {0, 0, 0, 0, 0, 0}};

        int nodes = graph.length;
        parent = new int[nodes];
        rank = new int[nodes];

        Arrays.fill(parent, -1);
        Arrays.fill(rank, 0);

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (graph[i][j] != 0) {
                    list.add(new Node(i, j, graph[i][j]));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list);

        System.out.println("Path: ");
        for (Node tmpNode : list) {
            union(tmpNode);
        }
        System.out.println("ans=" + ans);
    }

    private static void union(Node node) {
        int x = node.from;
        int y = node.to;

        int parentX = findParent(x);
        int parentY = findParent(y);

        if (parentX == parentY) return;
        else {
            if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
            } else if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
            } else {
                parent[parentX] = parentY;
                rank[parentX]++;
            }
        }
        System.out.println("from: " + node.from + " to:" + node.to + " weight: " + node.weight);
        ans += node.weight;
    }

    private static int findParent(int input) {
        if (parent[input] == -1) return input;
        return parent[input] = findParent(parent[input]);
    }
}
