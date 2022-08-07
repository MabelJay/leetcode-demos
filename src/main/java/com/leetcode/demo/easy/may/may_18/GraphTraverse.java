package com.leetcode.demo.easy.may.may_18;

import java.util.Arrays;

public class GraphTraverse {
    private char[] vertices;
    private int[][] arcs;
    private int vexNum;
    private boolean[] visited;

    public GraphTraverse(int count) {
        this.vexNum = count;
        vertices = new char[count];
        arcs = new int[count][count];
        visited = new boolean[count];
    }

    private void addEdge(int i, int j) {
        if (i == j) return;

        arcs[i][j] = 1;
        arcs[j][1] = 1;
    }

    public void setVertices(char[] vertices) {
        this.vertices = vertices;
    }

    public void setArcs(int[][] arcs) {
        this.arcs = arcs;
    }

    public void setVexNum(int vexNum) {
        this.vexNum = vexNum;
    }

    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    public static void main(String[] args) {
        GraphTraverse graphTraverse = new GraphTraverse(4);
        char[] vertArr = {'A', 'B', 'C', 'F'};
        graphTraverse.setVertices(vertArr);
        graphTraverse.addEdge(0, 1);
        graphTraverse.addEdge(1, 2);
        graphTraverse.addEdge(2, 3);

        graphTraverse.traverse();

    }

    public void traverse() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public void dfs(int vert) {
        visited[vert] = true;

        System.out.println(vertices[vert]);
        for (int i = 0; i < vexNum; i++) {
            if (arcs[vert][i] != 0 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
