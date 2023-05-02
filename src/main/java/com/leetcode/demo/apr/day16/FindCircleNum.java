package com.leetcode.demo.apr.day16;

import java.util.Arrays;

public class FindCircleNum {

    int[] parent;

    public static void main(String[] args) {
        // 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        //输出：2

        int[][] grid = getMatrix("110110001", 3, 3);
        printMatrix(grid);
        System.out.println(new FindCircleNum().findCircleNum(grid));
    }

    private static int[][] getMatrix(String s, int rows, int columns) {
        int[][] grid = new int[rows][columns];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (index > s.length() - 1) return grid;
                grid[i][j] = s.charAt(index++) - '0';
            }
        }
        return grid;
    }

    private static void printMatrix(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
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
        System.out.println(Arrays.toString(parent));
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) provinces++;
        }
        return provinces;
    }

    private void union(int index1, int index2) {
        int parent1 = findParent(index1);
        int parent2 = findParent(index2);
        if (parent1 == parent2) return;

        parent[parent1] = parent2;
    }

    private int findParent(int index) {
        if (index == parent[index]) return index;
        return parent[index] = findParent(parent[index]);
    }
}
