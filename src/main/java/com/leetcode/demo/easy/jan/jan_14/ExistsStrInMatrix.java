package com.leetcode.demo.easy.jan.jan_14;

public class ExistsStrInMatrix {

    public static void main(String[] args) {
        // 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
        //输出：true

        // [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]
        //'ABCB'

        // [['C','A','A'],['A','A','A'],['B','C','D']]
        //'AAB'

        // [['A','B','C','E'],['S','F','E','S'],['A','D','E','E']]
        //'ABCESEEEFS'

        // [['a','a','a','a'],['a','a','a','a'],['a','a','a','a']]
        //'aaaaaaaaaaaaa'

        char[][] board = {{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};

        char[][] board2 = {{'a', 'a'}, {'a', 'a'}};
        String s = "aaaaa";
        System.out.println(new ExistsStrInMatrix().exist(board, "aaaaaaaaaaaaa"));
    }

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = dfs(word, 0, i, j, board, visited);
                if (flag) return true;
            }
        }
        return false;
    }

    public boolean dfs(String word, int index, int x, int y, char[][] board, boolean[][] visited) {
        if (index == word.length()) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
        if (word.charAt(index) != board[x][y]) {
            visited[x][y] = false;
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        boolean flag = dfs(word, index + 1, x + 1, y, board, visited) || dfs(word, index + 1, x, y + 1, board, visited) ||
                dfs(word, index + 1, x - 1, y, board, visited) || dfs(word, index + 1, x, y - 1, board, visited);
        if (!flag) {
            visited[x][y] = false;
        }

        return flag;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
