package com.leetcode.demo.easy.may.may_18;

public class GraphTraverse2 {

    private static class Vert {
        char vert;

        public Vert(char vert) {
            this.vert = vert;
        }
    }

    int vertCount;
    int[][] arcs;
    int[] visited;

    public GraphTraverse2(int count) {
        this.vertCount = count;
        this.arcs = new int[26][26];
        visited = new int[26];
    }

    public void addEdge(Vert node1, Vert node2) {
        int index1 = node1.vert - '0';
        int index2 = node2.vert - '0';

        arcs[index1][index2] = 1;
        arcs[index2][index1] = 1;
        visited[index1] = 1;
    }

    public void traverseGraph() {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) {
                dfs(i);
            }
        }
    }

    public void dfs(int vert) {
        visited[vert] = 2;
        System.out.println((char)(vert + '0'));
        for (int i = 0; i < 26; i++) {
            if (arcs[vert][i] != 0 && visited[i] != 2) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Vert node1 = new Vert('A');
        Vert node2 = new Vert('B');
        Vert node3 = new Vert('C');
        Vert node4 = new Vert('F');

        GraphTraverse2 graphTraverse2 = new GraphTraverse2(4);
        graphTraverse2.addEdge(node1, node2);
        graphTraverse2.addEdge(node2, node3);
        graphTraverse2.addEdge(node3, node4);

        graphTraverse2.traverseGraph();
    }
}
