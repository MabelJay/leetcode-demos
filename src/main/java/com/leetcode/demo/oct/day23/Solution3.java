package com.leetcode.demo.oct.day23;

import java.util.LinkedList;

public class Solution3 {

    public static void main(String[] args) {
        // 输入：grid = [
        //  ['1','1','0','0','0'],
        //  ['1','1','0','0','0'],
        //  ['0','0','1','0','0'],
        //  ['0','0','0','1','1']
        //]
        //输出：3

        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(new Solution3().numIslands2(grid));
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int columns = grid[0].length;

        LinkedList<Integer> queue = new LinkedList<>();
        int islandsCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(i * columns + j);
                    islandsCount++;

                    while (!queue.isEmpty()) {
                        int id = queue.poll();
                        int curRow = id / columns;
                        int curColumn = id % columns;

                        if (curRow - 1 >= 0 && grid[curRow - 1][curColumn] == '1') {
                            queue.offer((curRow - 1) * columns + curColumn);
                            grid[curRow - 1][curColumn] = '0';
                        }
                        if (curRow + 1 < rows && grid[curRow + 1][curColumn] == '1') {
                            queue.offer((curRow + 1) * columns + curColumn);
                            grid[curRow + 1][curColumn] = '0';
                        }
                        if (curColumn - 1 >= 0 && grid[curRow][curColumn - 1] == '1') {
                            queue.offer(curRow * columns + curColumn - 1);
                            grid[curRow][curColumn - 1] = '0';
                        }
                        if (curColumn + 1 < columns && grid[curRow][curColumn + 1] == '1') {
                            queue.offer(curRow * columns + curColumn + 1);
                            grid[curRow][curColumn + 1] = '0';
                        }
                    }
                }
            }
        }
        return islandsCount;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int columns = grid[0].length;

        int islandsCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, rows, columns, i, j);
                    islandsCount++;
                }
            }
        }
        return islandsCount;
    }

    public void dfs(char[][] grid, int rows, int columns, int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns || grid[row][column] != '1') return;

        grid[row][column] = '0';
        dfs(grid, rows, columns, row - 1, column);
        dfs(grid, rows, columns, row + 1, column);
        dfs(grid, rows, columns, row, column - 1);
        dfs(grid, rows, columns, row, column + 1);
    }
}
