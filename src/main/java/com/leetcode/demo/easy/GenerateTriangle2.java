package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GenerateTriangle2 {
    public static void main(String[] args) {
        System.out.println(new GenerateTriangle2().getRow5(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        if (rowIndex < 0) return tmpList;

        for (int i = 0; i <= rowIndex; i++) {
            tmpList = new ArrayList<>();
            for (int j = 0; j < (i + 1); j++) {
                if (j == 0 || j == i) {
                    tmpList.add(1);
                } else {
                    int val = list.get(i - 1).get(j) + list.get(i - 1).get(j - 1);
                    tmpList.add(val);
                }
            }
            list.add(tmpList);
        }
        return list.get(rowIndex);
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> preList = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        if (rowIndex < 0) return tmpList;

        for (int i = 1; i <= rowIndex; i++) {
            tmpList.clear();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tmpList.add(1);
                } else {
                    int val = preList.get(j) + preList.get(j - 1);
                    tmpList.add(val);
                }
            }
            preList = List.copyOf(tmpList);
        }
        return preList;
    }

    public List<Integer> getRow3(int rowIndex) {
        List<Integer> preList = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tmpList.add(1);
                } else {
                    int val = preList.get(j) + preList.get(j - 1);
                    tmpList.add(val);
                }
            }
            preList = tmpList;
        }
        return preList;
    }

    public List<Integer> getRow4(int rowIndex) {
        List<Integer> tmpList = new ArrayList<>();
        if (rowIndex < 0) return tmpList;

        tmpList.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            tmpList.add(0);
            for (int j = i; j > 0; j--) {
                tmpList.set(j, tmpList.get(j) + tmpList.get(j - 1));
            }
        }
        return tmpList;
    }

    public List<Integer> getRow5(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}
