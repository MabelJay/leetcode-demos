package com.leetcode.demo.apr.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KruskalDemo {

    private static class Node implements Comparable<Node> {
        int from;
        int to;
        int val;

        Node(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    private static int[] parent;
    private static int[] rank;
    static List<Node> list = new ArrayList<>();
    private static int ans = 0;

    public static void main(String[] args) {
        int[][] graph =
                {{0, 6, 1, 5, 0, 0},
                        {0, 0, 5, 0, 3, 0},
                        {0, 0, 0, 5, 6, 4},
                        {0, 0, 0, 0, 0, 2},
                        {0, 0, 0, 0, 0, 6},
                        {0, 0, 0, 0, 0, 0}};

        int nodeCount = graph.length;
        parent = new int[nodeCount];
        rank = new int[nodeCount];

        Arrays.fill(parent, -1);
        Arrays.fill(rank, 0);

        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++) {
                if (graph[i][j] != 0) {
                    list.add(new Node(i, j, graph[i][j]));
                }
            }
        }

        Collections.sort(list);
        System.out.println(list);

        for (int i = 0; i < nodeCount; i++) {
            Node node = list.get(i);
            unionNode(node);
        }
        System.out.println(ans);
    }

    public static void unionNode(Node node) {
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
        ans += node.val;
    }

    public static int findParent(int input) {
        if (parent[input] == -1) return input;
        return parent[input] = findParent(parent[input]);
    }
}
