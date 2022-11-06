package com.leetcode.demo.sep.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal {

    public static void main(String[] args) {
        // 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        //输出：11

        int[][] arr = {{-10}};
        MinimumTotal minimumTotal = new MinimumTotal();
        System.out.println(minimumTotal.minimumTotal(minimumTotal.getList(arr)));
    }

    public List<List<Integer>> getList(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] ints : arr) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < ints.length; j++) {
                tmpList.add(ints[j]);
            }
            list.add(tmpList);
        }
        return list;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0 && j < i) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
            }
        }

        return Arrays.stream(dp[size - 1]).min().getAsInt();
    }
}
