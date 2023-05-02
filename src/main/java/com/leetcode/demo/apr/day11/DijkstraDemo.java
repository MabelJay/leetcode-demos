package com.leetcode.demo.apr.day11;

public class DijkstraDemo {

    private static final int NODE_COUNTS = 6;
    private static final int MAX_VALUE = Integer.MAX_VALUE;
    private static String[] vertexes = new String[NODE_COUNTS];

    public static void main(String[] args) {

    }

    public static int[][] createGraph() {
        int[][] graph = new int[][]{
                {0, 1, MAX_VALUE, MAX_VALUE, 2, MAX_VALUE},
                {1, 0, 1, MAX_VALUE, MAX_VALUE, MAX_VALUE},
                {MAX_VALUE, 1, 0, 1, MAX_VALUE, MAX_VALUE},
                {MAX_VALUE, MAX_VALUE, 1, 0, 1, MAX_VALUE},
                {MAX_VALUE, MAX_VALUE, MAX_VALUE, 1, 0, 1},
                {MAX_VALUE, MAX_VALUE, MAX_VALUE, 1, 1, 0}
        };

        vertexes[0] = "A";
        vertexes[1] = "B";
        vertexes[2] = "C";
        vertexes[3] = "D";
        vertexes[4] = "E";
        vertexes[5] = "F";
        return graph;
    }

    private static void dijkstra() {
        boolean[] visited = new boolean[NODE_COUNTS];
    }
}
