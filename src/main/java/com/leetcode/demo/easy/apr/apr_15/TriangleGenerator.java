package com.leetcode.demo.easy.apr.apr_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleGenerator {

    public static void main(String[] args) {
        // 输入: numRows = 5
        //输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

        System.out.println(new TriangleGenerator().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tmpList;

        for (int i = 0; i < numRows; i++) {
            tmpList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) tmpList.add(1);
                else {
                    tmpList.add(resList.get(i - 1).get(j - 1) + resList.get(i - 1).get(j));
                }
            }
            resList.add(tmpList);
        }
        return resList;
    }
}
