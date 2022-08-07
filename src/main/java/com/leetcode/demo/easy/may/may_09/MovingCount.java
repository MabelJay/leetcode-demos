package com.leetcode.demo.easy.may.may_09;

public class MovingCount {

    int count;
    boolean[][] visited;

    public static void main(String[] args) {
        // 输入：m = 2, n = 3, k = 1
        //输出：3

        // 输入：m = 3, n = 1, k = 0
        //输出：1

        System.out.println(new MovingCount().movingCount(3, 1, 0));
    }

    public int movingCount(int m, int n, int k) {
        count = 0;
        visited = new boolean[m][n];
        dfs(0, 0, k, m, n);
        return count;
    }

    public void dfs(int row, int column, int k, int m, int n) {
        if (row < 0 || row >= m || column < 0 || column >= n || visited[row][column] || moreThanK(row, column, k))
            return;

        visited[row][column] = true;
        count++;
        dfs(row, column - 1, k, m, n);
        dfs(row, column + 1, k, m, n);
        dfs(row - 1, column, k, m, n);
        dfs(row + 1, column, k, m, n);
    }

    public boolean moreThanK(int num1, int num2, int k) {
        int sum = 0;
//        System.out.println("num1=" + num1 + " num2=" + num2);
        while (num1 != 0 || num2 != 0) {
            if (num1 == 0) {
                sum += num2 % 10;
            } else if (num2 == 0) {
                sum += num1 % 10;
            } else {
                sum += num1 % 10 + num2 % 10;
            }
            num2 /= 10;
            num1 /= 10;
            if (sum > k) return true;
        }
        return false;
    }
}
