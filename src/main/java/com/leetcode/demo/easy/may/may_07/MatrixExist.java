package com.leetcode.demo.easy.may.may_07;

public class MatrixExist {
    int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        // 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
        //输出：true

        // [['a','b']]
        //'ba'

        // [['A','B','C','E'],['S','F','E','S'],['A','D','E','E']]
        //'ABCESEEEFS'
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new MatrixExist().exist(board, "ABCESEEEFS"));

    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = dfs(board, i, j, word, 0);
                if (flag) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int indexRow, int indexColumn, String word, int index) {
        if (board[indexRow][indexColumn] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;

        char temp = board[indexRow][indexColumn];
        board[indexRow][indexColumn] = '0';
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            int nx = indexRow + directions[i][0];
            int ny = indexColumn + directions[i][1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] != '0') {
                boolean flag = dfs(board, nx, ny, word, index + 1);
                if (flag) {
                    result = true;
                    break;
                }
            }
        }
        board[indexRow][indexColumn] = temp;
        return result;
    }
}
