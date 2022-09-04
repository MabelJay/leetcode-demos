package com.leetcode.demo.sep_04;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        //输入：candidates = [2,3,6,7], target = 7
        //输出：[[2,2,3],[7]]

        // 输入: candidates = [2,3,5], target = 8
        //输出: [[2,2,2,2],[2,3,3],[3,5]]

        int[] candidates = {2, 3, 6, 7};
        System.out.println(new CombinationSum().combinationSum(candidates, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return resList;

        combine(resList, new ArrayList<>(), 0, candidates, target);
        return resList;
    }

    public void combine(List<List<Integer>> list, List<Integer> combination,
                        int index, int[] candidates, int target) {
        if (target == 0) {
            list.add(new ArrayList<>(combination));
            return;
        }
        if (index == candidates.length) return;

        combine(list, combination, index + 1, candidates, target);

        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            combine(list, combination, index, candidates, target - candidates[index]);
            combination.remove(combination.size() - 1);
        }
    }
}
