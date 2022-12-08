package com.leetcode.demo.dec.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {

    public static void main(String[] args) {
        System.out.println(new SolveNQueens().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resList = new ArrayList<>();
        if (n <= 0) return resList;
        int[] record = new int[n];
        Arrays.fill(record, -1);
        process2(record, 0, n, resList);
        return resList;
    }

    public void process2(int[] records, int i, int n, List<List<String>> list) {
        if (i == n) {
            list.add(getList(records, i));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid2(records, i, j)) {
                records[i] = j;
                process2(records, i + 1, n, list);
            }
        }
    }

    public List<String> getList(int[] records, int n) {
        List<String> list = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            if (records[j] != -1) {
                row[records[j]] = 'Q';
            }
            list.add(new String(row));
        }
        return list;
    }

    public boolean isValid2(int[] records, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (records[k] == j || Math.abs(k - i) == Math.abs(records[k] - j)) return false;
        }
        return true;
    }

    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        int[] record = new int[n];
        return process(0, record, n);
    }

    public static int process(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(k - i) == Math.abs(record[k] - j)) {
                return false;
            }
        }
        return true;
    }
}
