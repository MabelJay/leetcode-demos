package com.leetcode.demo.easy.may.may_01;

public class GetMaximumGold {


    int maxValue;
    int sum;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        // 输入：grid = {{0,6,0},{5,8,7},{0,9,0}}
        //输出：24
        // {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}

        // 输入：grid = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}}
        //输出：28
        int[][] grid = {{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};

        // {{0,0,0,0,0,0,32,0,0,20},{0,0,2,0,0,0,0,40,0,32},{13,20,36,0,0,0,20,0,0,0},{0,31,27,0,19,0,0,25,18,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,18,0,6},{0,0,0,25,0,0,0,0,0,0},{0,0,0,21,0,30,0,0,0,0},{19,10,0,0,34,0,2,0,0,27},{0,0,0,0,0,34,0,0,0,0}}
        // 129

        int[][] grid2 = {{0, 0, 0, 0, 0, 0, 32, 0, 0, 20}, {0, 0, 2, 0, 0, 0, 0, 40, 0, 32}, {13, 20, 36, 0, 0, 0, 20, 0, 0, 0}, {0, 31, 27, 0, 19, 0, 0, 25, 18, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 18, 0, 6}, {0, 0, 0, 25, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 21, 0, 30, 0, 0, 0, 0},
                {19, 10, 0, 0, 34, 0, 2, 0, 0, 27}, {0, 0, 0, 0, 0, 34, 0, 0, 0, 0}};

        int[][] grid3 = {{0, 0, 2, 0}, {13, 20, 36, 0}, {0, 31, 27, 0}};
        new GetMaximumGold().printMatrix(grid3);
        System.out.println(new GetMaximumGold().getMaximumGold(grid3));
    }

    public int getMaximumGold(int[][] grid) {
        maxValue = 0;
        int m = grid.length;
        int n = grid[0].length;
        sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j, sum);
                }
            }
        }
        return maxValue;
    }

    public void dfs(int[][] grid, int row, int column, int sum) {
        sum += grid[row][column];
        maxValue = Math.max(sum, maxValue);

        int temp = grid[row][column];
        grid[row][column] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = row + dir[i][0];
            int ny = column + dir[i][1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] > 0) {
                dfs(grid, nx, ny, sum);
            }
        }
        grid[row][column] = temp;
    }

    public void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
