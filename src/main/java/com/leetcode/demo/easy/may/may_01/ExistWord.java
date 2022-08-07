package com.leetcode.demo.easy.may.may_01;

public class ExistWord {

    int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        // 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        //输出：true

        // 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
        // true
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board1 = {{'a'}};
        System.out.println(new ExistWord().exist(board, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    boolean flag = check(board, word, 0, i, j);
                    if (flag) return true;
                }
            }
            return false;
    }

    public boolean check(char[][] board, String word, int index, int row, int column) {
        if (word.charAt(index) != board[row][column]) return false;
        if (index == word.length() - 1) return true;

        char temp = board[row][column];
        boolean result = false;
        board[row][column] = '0';
        for (int i = 0; i < 4; i++) {
            int nx = row + dir[i][0];
            int ny = column + dir[i][1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] != '0') {
                boolean flag = check(board, word, index + 1, nx, ny);
                if (flag) {
                    result = true;
                    break;
                }
            }
        }
        board[row][column] = temp;
        return result;
    }
}
