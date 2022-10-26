package com.leetcode.demo.oct.day22;

import java.util.LinkedList;

public class NumIslands {

    public static void main(String[] args) {
        // 输入：grid = [
        //  ['1','1','1','1','0'],
        //  ['1','1','0','1','0'],
        //  ['1','1','0','0','0'],
        //  ['0','0','0','0','0']
        //]
        //输出：1

        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(new NumIslands().numIslands2(grid));
    }

    // BFS
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length, columns = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<>();
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    queue.offer(i * columns + j);
                    while (!queue.isEmpty()) {
                        int id = queue.poll();
                        int row = id / columns;
                        int column = id % columns;
                        if (row - 1 >= 0 && grid[row - 1][column] == '1') {
                            queue.offer((row - 1) * columns + column);
                            grid[row - 1][column] = '0';
                        }
                        if (row + 1 < rows && grid[row + 1][column] == '1') {
                            queue.offer((row + 1) * columns + column);
                            grid[row + 1][column] = '0';
                        }

                        if (column - 1 >= 0 && grid[row][column - 1] == '1') {
                            queue.offer(row * columns + column - 1);
                            grid[row][column - 1] = '0';
                        }

                        if (column + 1 < columns && grid[row][column + 1] == '1') {
                            queue.offer(row * columns + column + 1);
                            grid[row][column + 1] = '0';
                        }
                    }
                }
            }
        }
        return islandCount;
    }

    // DFS
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;

        int islandCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, rows, columns, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public void dfs(char[][] grid, int rows, int columns, int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';
        dfs(grid, rows, columns, row - 1, column);
        dfs(grid, rows, columns, row + 1, column);
        dfs(grid, rows, columns, row, column - 1);
        dfs(grid, rows, columns, row, column + 1);
    }
}
