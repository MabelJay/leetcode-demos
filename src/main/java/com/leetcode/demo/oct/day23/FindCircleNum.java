package com.leetcode.demo.oct.day23;

import java.util.LinkedList;

public class FindCircleNum {

    boolean[] visited;

    public static void main(String[] args) {
        // 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        //输出：2
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new FindCircleNum().findCircleNum2(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
        int cities = isConnected.length;

        visited = new boolean[cities];
        int provinces = 0;
        int rows = isConnected.length;

        for (int i = 0; i < rows; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, cities, i);
            }
        }
        return provinces;
    }

    // dfs
    public void dfs(int[][] isConnected, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(isConnected, cities, j);
            }
        }
    }

    // bfs
    public int findCircleNum2(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
        int cities = isConnected.length;

        visited = new boolean[cities];
        LinkedList<Integer> queue = new LinkedList<>();
        int provinces = 0;

        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                provinces++;
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
            }
        }
        return provinces;
    }
}
