package com.leetcode.demo.sep_12;

public class ExistWords {

    boolean[][] visited;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        // 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        //输出：true
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCEDd";
        System.out.println(new ExistWords().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        visited = new boolean[rows][columns];
        boolean flag;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                flag = dfs(board, word, 0, i, j);
                if (flag) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int row, int column) {
        if (index == word.length()) return true;
        if (row >= board.length || column >= board[0].length || row < 0 || column < 0 || visited[row][column])
            return false;

        boolean result = false;
        if (board[row][column] == word.charAt(index)) {
            visited[row][column] = true;

            boolean flag;
            for (int[] direction : directions) {
                flag = dfs(board, word, index + 1, row + direction[0], column + direction[1]);
                if (flag) {
                    result = true;
                    break;
                }
            }
            visited[row][column] = false;
        }
        return result;
    }
}
