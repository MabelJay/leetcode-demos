package com.leetcode.demo.easy.june.june_26;

import java.util.LinkedList;

public class FindCircleNum {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new FindCircleNum().findCircleNum2(grid));
    }

    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;

        boolean[] visited = new boolean[cities];
        int count = 0;

        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, cities, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int cities, boolean[] visited, int i) {
        for (int j = 0; j < cities; j++) {
            if (grid[i][j] != 0 && !visited[j]) {
                visited[j] = true;
                dfs(grid, cities, visited, j);
            }
        }
    }

    public int findCircleNum2(int[][] isConnected) {
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
                        if (isConnected[j][k] != 0 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
