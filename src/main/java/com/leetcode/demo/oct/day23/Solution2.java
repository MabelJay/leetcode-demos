package com.leetcode.demo.oct.day23;

public class Solution2 {
    static class UnionIsland {
        int count;
        int[] parent;
        int[] rank;

        public UnionIsland(char[][] grid, int rows, int columns) {
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

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int index1, int index2) {
            int rootx = find(index1);
            int rooty = find(index2);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
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

        UnionIsland islands = new UnionIsland(grid, rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        islands.union(i * columns + j, (i - 1) * columns + j);
                    }
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        islands.union(i * columns + j, (i + 1) * columns + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        islands.union(i * columns + j, i * columns + j - 1);
                    }
                    if (j + 1 <= columns && grid[i][j + 1] == '1') {
                        islands.union(i * columns + j, i * columns + j + 1);
                    }
                }
            }
        }
        return islands.getCount();
    }

    public static void main(String[] args) {
        // 输入：grid = [
        //  ['1','1','1','1','0'],
        //  ['1','1','0','1','0'],
        //  ['1','1','0','0','0'],
        //  ['0','0','0','0','0']
        //]
        //输出：1

        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(new Solution2().numIslands(grid));
    }
}
