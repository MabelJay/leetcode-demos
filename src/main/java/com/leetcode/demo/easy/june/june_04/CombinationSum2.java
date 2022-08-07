package com.leetcode.demo.easy.june.june_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        // 输入: candidates = [10,1,2,7,6,1,5], target = 8,
        //输出:
        //[
        //[1,1,6],
        //[1,2,5],
        //[1,7],
        //[2,6]
        //]

        // 输入: candidates = [2,5,2,1,2], target = 5,
        //输出:
        //[
        //[1,2,2],
        //[5]
        //]

        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(new CombinationSum2().combinationSum2(arr, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return list;
        Arrays.sort(candidates);
        dfs(candidates, 0, new ArrayList<>(), list, target);
        return list;
    }

    public void dfs(int[] arr, int index, List<Integer> combine, List<List<Integer>> list, int target) {
        if (target == 0) {
            list.add(new ArrayList<>(combine));
            return;
        }
        if (index == arr.length) return;

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (target >= arr[i]) {
                combine.add(arr[i]);
                dfs(arr, i + 1, combine, list, target - arr[i]);
                combine.remove(combine.size() - 1);
            } else break;
        }
    }
}
