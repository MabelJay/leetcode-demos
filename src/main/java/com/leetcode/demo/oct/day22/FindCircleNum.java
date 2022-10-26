package com.leetcode.demo.oct.day22;

import java.util.Arrays;
import java.util.LinkedList;

public class FindCircleNum {

    boolean[] visited;

    public static void main(String[] args) {
        //输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        //输出：2

        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new FindCircleNum().findCircleNum3(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
        int cities = isConnected.length;
        visited = new boolean[cities];
        int province = 0;

        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, cities, i);
                province++;
            }
        }
        return province;
    }

    public void dfs(int[][] isConnected, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(isConnected, cities, j);
            }
        }
    }

    public int findCircleNum2(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
        int cities = isConnected.length;
        int province = 0;
        visited = new boolean[cities];

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < cities; k++) {
                        if (!visited[k] && isConnected[j][k] == 1) {
                            queue.offer(k);
                        }
                    }
                }
                province++;
            }
        }
        return province;
    }

    public int findCircleNum3(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;

        int cities = isConnected.length;
        int[] parent = new int[cities];
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                    System.out.println(Arrays.toString(parent));
                }
            }
        }

        int province = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) province++;
        }
        return province;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
