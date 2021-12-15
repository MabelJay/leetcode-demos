package com.leetcode.demo.easy;

import java.util.*;

public class FindRelativeRanks {

    public static void main(String[] args) {
        // 输入：score = [5,4,3,2,1]
        //输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
        //["Gold Medal","5","Bronze Medal","Silver Medal","4"]
        //10,3,8,9,4
        int[] scores = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new FindRelativeRanks().findRelativeRanks2(scores)));
    }

    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        String[] res = new String[len];

        List<Integer> list = new ArrayList<>();
        for (Integer i : score) {
            list.add(i);
        }

        Arrays.sort(score);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(score[i], (len - i));
        }
        for (int i = 0; i < len; i++) {
            int val = map.get(list.get(i));
            if (val == 1) {
                res[i] = "Gold Medal";
            } else if (val == 2) {
                res[i] = "Silver Medal";
            } else if (val == 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = "" + val;
            }
        }
        return res;
    }

    public String[] findRelativeRanks2(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }
        return ans;
    }
}
