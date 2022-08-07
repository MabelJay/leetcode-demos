package com.leetcode.demo.easy.may.may_18;

import java.util.*;

public class GraphTraverse3 {
    char[] vertices;
    int vertCount;
    Map<Integer, Set<Integer>> map;
    boolean[] visited;


    public GraphTraverse3(int count, char[] vertices) {
        this.vertCount = count;
        this.map = new HashMap<>();
        this.vertices = vertices;
        visited = new boolean[count];
    }

    public void addEdge(int i, int j) {
        Set<Integer> set;
        if (map.containsKey(i)) {
            set = map.get(i);
        } else {
            set = new HashSet<>();
        }
        set.add(j);
        map.put(i, set);
    }

    public void traverse() {
        for (int i = 0; i < vertCount; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public void dfs(int u) {
        visited[u] = true;
        System.out.println(vertices[u]);
        if (map.containsKey(u)) {
            for (int v : map.get(u)) {
                if (!visited[v]) {
                    dfs(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[] verts = {'A', 'B', 'C', 'F'};
        GraphTraverse3 graphTraverse3 = new GraphTraverse3(4, verts);
        graphTraverse3.addEdge(0, 1);
        graphTraverse3.addEdge(1, 2);
        graphTraverse3.addEdge(2, 3);

        graphTraverse3.traverse();
    }
}
