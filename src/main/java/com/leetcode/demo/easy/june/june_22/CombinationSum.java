package com.leetcode.demo.easy.june.june_22;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        // 输入: candidates = [2,3,6,7], target = 7
        //输出: [[7],[2,2,3]]

        // 输入: candidates = [2,3,5], target = 8
        //输出: [[2,2,2,2],[2,3,3],[3,5]]

        // [2,7,6,3,5,1]
        //9
        int[] candidates = {2, 7, 6, 3, 5, 1};
        System.out.println(new CombinationSum().combinationSum(candidates, 9));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }

    public void dfs(int[] candidates, int target, int index, List<Integer> combine, List<List<Integer>> list) {
        if (index == candidates.length) return;

        if (target == 0) {
            list.add(new ArrayList<>(combine));
            return;
        }

        if (target >= candidates[index]) {
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], index, combine, list);
            combine.remove(combine.size() - 1);
        }
        dfs(candidates, target, index + 1, combine, list);
    }
}
