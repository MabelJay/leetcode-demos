package com.leetcode.demo.sep_04;

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

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(new CombinationSum2().combinationSum2(candidates, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return list;
        Arrays.sort(candidates);
        combine(list, new ArrayList<>(), 0, candidates, target);
        return list;
    }

    public void combine(List<List<Integer>> list, List<Integer> combine, int index, int[] candidates, int target) {
        if (target == 0) {
            list.add(new ArrayList<>(combine));
            return;
        }
        if (index == candidates.length) return;

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (target >= candidates[i]) {
                combine.add(candidates[i]);
                combine(list, combine, i + 1, candidates, target - candidates[i]);
                combine.remove(combine.size() - 1);
            } else break;
        }
    }
}
