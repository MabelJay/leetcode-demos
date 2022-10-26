package com.leetcode.demo.oct.day23;

public class FindCircleNum2 {

    int[] parent;

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new FindCircleNum2().findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
        int cities = isConnected.length;

        int province = 0;
        parent = new int[cities];
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) province++;
        }
        return province;
    }

    public void union(int index1, int index2) {
        parent[find(index1)] = parent[find(index2)];
    }

    public int find(int index) {
        if (parent[index] != index) parent[index] = find(parent[index]);
        return parent[index];
    }
}
