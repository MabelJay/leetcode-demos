package com.leetcode.demo.easy.apr.apr_26;

public class NumIslands {

    public static void main(String[] args) {
        // 输入：grid = [
        //  ["1","1","1","1","0"],
        //  ["1","1","0","1","0"],
        //  ["1","1","0","0","0"],
        //  ["0","0","0","0","0"]
        //]
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col, int m, int n) {
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0') return;

        grid[row][col] = '0';
        dfs(grid, row + 1, col, m, n);
        dfs(grid, row - 1, col, m, n);
        dfs(grid, row, col + 1, m, n);
        dfs(grid, row, col - 1, m, n);
    }
}
