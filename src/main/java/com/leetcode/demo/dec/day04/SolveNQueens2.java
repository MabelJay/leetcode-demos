package com.leetcode.demo.dec.day04;

public class SolveNQueens2 {

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {
        if (n < 1) return 0;
        int[] record = new int[n];
        return process(record, 0, n);
    }

    public static int process(int[] record, int i, int n) {
        if (i == n) return 1;

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(record, i + 1, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(i - k) == Math.abs(record[i] - j)) {
                return false;
            }
        }
        return true;
    }
}
