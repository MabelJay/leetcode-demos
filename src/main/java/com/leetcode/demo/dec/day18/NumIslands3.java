package com.leetcode.demo.dec.day18;

public class NumIslands3 {

    private static class UnionFind {
        int count;
        int[] parent;
        int[] sizeArr;

        public UnionFind(char[][] grid, int rows, int columns) {
            this.count = 0;
            parent = new int[rows * columns];
            sizeArr = new int[rows * columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * columns + j] = i * columns + j;
                        count++;
                    }
                }
            }
        }

        private int findParent(int index) {
            if (parent[index] != index) {
                parent[index] = findParent(parent[index]);
            }
            return parent[index];
        }

        private void union(int index1, int index2) {
            int parent1 = findParent(index1);
            int parent2 = findParent(index2);

            if (parent1 != parent2) {
                if (sizeArr[parent1] > sizeArr[parent2]) {
                    parent[parent2] = parent1;
                    sizeArr[parent1] += sizeArr[parent2];
                } else {
                    parent[parent1] = parent2;
                    sizeArr[parent2] += sizeArr[parent1];
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(new NumIslands3().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;

        UnionFind unionFind = new UnionFind(grid, rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        unionFind.union(i * columns + j, (i - 1) * columns + j);
                    }
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        unionFind.union(i * columns + j, (i + 1) * columns + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * columns + j, i * columns + j - 1);
                    }
                    if (j + 1 < columns && grid[i][j + 1] == '1') {
                        unionFind.union(i * columns + j, i * columns + j + 1);
                    }
                }
            }
        }
        return unionFind.getCount();
    }
}
