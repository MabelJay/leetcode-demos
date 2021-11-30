package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.List;

public class GenerateTriangle {

    public static void main(String[] args) {

        int numRows = 5;
        System.out.println(new GenerateTriangle().generate(numRows));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList;
        if (numRows < 1) return list;

        for (int i = 0; i < numRows; i++) {
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
        return list;
    }
}
