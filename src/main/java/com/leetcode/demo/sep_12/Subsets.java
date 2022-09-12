package com.leetcode.demo.sep_12;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        // 输入：nums = [1,2,3]
        //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

        int[] nums = {1, 2, 3, 4};
        int[] nums2 = {0};
        System.out.println(new Subsets().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;

        dfs(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public void dfs(List<List<Integer>> list, List<Integer> combine, int[] nums, int index) {
        if (index == nums.length) {
            list.add(new ArrayList<>(combine));
            return;
        }

        dfs(list, combine, nums, index + 1);
        combine.add(nums[index]);
        dfs(list, combine, nums, index + 1);
        combine.remove(combine.size() - 1);
    }
}
