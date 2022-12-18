package com.leetcode.demo.dec.day18;

public class NumIslands {

    public static void main(String[] args) {
        // 输入：grid = [
        //  ["1","1","0","0","0"],
        //  ["1","1","0","0","0"],
        //  ["0","0","1","0","0"],
        //  ["0","0","0","1","1"]
        //]
        //输出：3

        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(new NumIslands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int columns = grid[0].length;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, j, i, columns, rows);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int col, int row, int columns, int rows) {
        if (col < 0 || col > columns - 1 || row < 0 || row > rows - 1 || grid[row][col] != '1') return;

        grid[row][col] = '2';
        dfs(grid, col - 1, row, columns, rows);
        dfs(grid, col + 1, row, columns, rows);
        dfs(grid, col, row - 1, columns, rows);
        dfs(grid, col, row + 1, columns, rows);
    }
}
