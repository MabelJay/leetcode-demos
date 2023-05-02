package com.leetcode.demo.apr.day16;

import java.util.Arrays;
import java.util.LinkedList;

public class FindCircleNum2 {

    int[] parent;

    public static void main(String[] args) {
        // 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        //输出：2

        // 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
        //输出：3

        int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(new FindCircleNum2().findCircleNum2(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;

        int cities = isConnected.length;
        parent = new int[cities];
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
        }

        int count = 0;
        for (int i = 0; i < cities; i++) {
            for (int j = 0; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) count++;
        }
        return count;
    }

    private void union(int index1, int index2) {
        int index1F = findParent(index1);
        int index2F = findParent(index2);

        if (index1F == index2F) return;
        parent[index1F] = index2F;
    }

    private int findParent(int index) {
        if (parent[index] == index) return index;
        return parent[index] = findParent(parent[index]);
    }

    public int findCircleNum2(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;

        int cities = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[cities];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < cities; k++) {
                        if (isConnected[j][k] != 0 && !visited[k]) queue.offer(k);
                    }
                }
                count++;
            }
        }
        return count;
    }
}
