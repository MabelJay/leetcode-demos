package com.leetcode.demo.oct.day23;

public class Solution4 {
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid, int rows, int columns) {
            count = 0;
            parent = new int[rows * columns];
            rank = new int[rows * columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * columns + j] = i * columns + j;
                        count++;
                    }
                }
            }
        }

        public int find(int index) {
            if (parent[index] != index) parent[index] = find(parent[index]);
            return parent[index];
        }

        public void union(int index1, int index2) {
            int x = find(index1);
            int y = find(index2);

            if (x != y) {
                if (rank[x] > rank[y]) {
                    parent[y] = x;
                } else if (rank[x] < rank[y]) {
                    parent[x] = y;
                } else {
                    parent[y] = x;
                    rank[x]++;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;

        UnionFind uf = new UnionFind(grid, rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(i * columns + j, (i - 1) * columns + j);
                    }
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        uf.union(i * columns + j, (i + 1) * columns + j);
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(i * columns + j, i * columns + j - 1);
                    }

                    if (j + 1 < columns && grid[i][j + 1] == '1') {
                        uf.union(i * columns + j, i * columns + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(new Solution4().numIslands(grid));
    }
}
