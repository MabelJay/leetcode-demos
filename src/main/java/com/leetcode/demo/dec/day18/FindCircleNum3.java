package com.leetcode.demo.dec.day18;

public class FindCircleNum3 {

    int[] parent;

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(new FindCircleNum3().findCircleNum(isConnected));
    }

    public int findHead(int index) {
        if (index != parent[index]) {
            parent[index] = findHead(parent[index]);
        }
        return parent[index];
    }

    public void union(int index1, int index2) {
        int index1F = findHead(index1);
        int index2F = findHead(index2);

        if (index1F != index2F) {
            parent[index2F] = index1F;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;

        int cities = isConnected.length;
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

        int province = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) {
                province++;
            }
        }
        return province;
    }
}
