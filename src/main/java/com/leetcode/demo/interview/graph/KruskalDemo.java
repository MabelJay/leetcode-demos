package com.leetcode.demo.interview.graph;

import com.leetcode.demo.apr.day04.graph.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KruskalDemo {

    private static class Edge implements Comparable<Edge> {
        int weight;
        int from;
        int to;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight > o.weight ? 1 : -1;
        }
    }

    static int[] parent;
    static int[] rank;
    static List<Edge> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 6, 1, 5, 0, 0},
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
                    list.add(new Edge(i, j, graph[i][j]));
                }
            }
        }
        Collections.sort(list);

        for (Edge tmpNode : list) {
            union(tmpNode);
        }
        System.out.println("count = " + count);
    }

    private static void union(Edge node) {
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
        count += node.weight;
    }

    private static int findParent(int index) {
        if (parent[index] == -1) return index;
        return parent[index] = findParent(parent[index]);
    }
}
