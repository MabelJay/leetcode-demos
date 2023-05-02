package com.leetcode.demo.apr.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal {

    public static void main(String[] args) {
        // 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        //输出：11

        // 输入：triangle = [[-10]]
        //输出：-10

        // [[-1],[2,3],[1,-1,-3]]
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        int[][] triangle2 = {{-10}};
        int[][] triangle3 = {{-1}, {2, 3}, {1, -1, -3}};
        List<List<Integer>> list = getList(triangle3);
        System.out.println(list);
        System.out.println(new MinimumTotal().minimumTotal2(list));
    }

    private static List<List<Integer>> getList(int[][] grid) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] ints : grid) {
            List<Integer> tmpList = new ArrayList<>();
            for (int anInt : ints) {
                tmpList.add(anInt);
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
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        return Arrays.stream(dp[size - 1]).min().getAsInt();
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < size; i++) {
            int tmpSize = triangle.get(i).size();
            for (int j = tmpSize - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] += triangle.get(i).get(j);
                } else if (j == tmpSize - 1) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
