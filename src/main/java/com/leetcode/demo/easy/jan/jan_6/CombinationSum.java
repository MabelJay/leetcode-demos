package com.leetcode.demo.easy.jan.jan_6;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        // 输入：candidates = [2,3,6,7], target = 7
        //输出：[[2,2,3],[7]]
        int[] candidates = {2, 3, 5};
        System.out.println(new CombinationSum().combinationSum(candidates, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return list;
        dfs(candidates, 0, target, list, new ArrayList<>());
        return list;
    }


    public void dfs(int[] candidates, int index, int target, List<List<Integer>> ans, List<Integer> combine) {
        if (index == candidates.length) return;
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        // skip current value
        dfs(candidates, index + 1, target, ans, combine);

        //choose current value
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs(candidates, index, target - candidates[index], ans, combine);
            combine.remove(combine.size() - 1);
        }
    }
}
