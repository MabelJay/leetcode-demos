package com.leetcode.demo.easy.jan.jan_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    public static void main(String[] args) {
        // 输入：nums = [1,2,2]
        //输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

        // [-1,1,2]
        int[] nums = {1, 2, 2};
        System.out.println(new SubsetsWithDup().subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), 0, false);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> combine, int index, boolean choosePre) {
        if (index == nums.length) {
            res.add(new ArrayList<>(combine));
            return;
        }

        dfs(nums, res, combine, index + 1, false);
        if (!choosePre && index > 0 && nums[index - 1] == nums[index]) {
            return;
        }
        combine.add(nums[index]);
        dfs(nums, res, combine, index + 1, true);
        combine.remove(combine.size() - 1);
    }
}
