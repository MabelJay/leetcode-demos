package com.leetcode.demo.sep_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    public static void main(String[] args) {
        // 输入：nums = [1,2,2]
        //输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
        int[] nums = {1, 2, 2};
        System.out.println(new SubsetsWithDup().subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;

        Arrays.sort(nums);
        dfs(list, new ArrayList<>(), 0, nums);
        return list;
    }

    public void dfs(List<List<Integer>> list, List<Integer> combine, int index, int[] nums) {
        if (index == nums.length) {
            list.add(new ArrayList<>(combine));
            return;
        }

        combine.add(nums[index]);
        dfs(list, combine, index + 1, nums);
        combine.remove(combine.size() - 1);

        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++;
        }
        dfs(list, combine, index + 1, nums);
    }
}
