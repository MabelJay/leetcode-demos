package com.leetcode.demo.easy.jan.jan_14;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        // 输入：nums = [1,2,3]
        //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        int[] nums = {1, 2, 3};
        System.out.println(new Subsets().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length == 0) return resList;
        dfs(nums, new ArrayList<>(), resList, 0);
        return resList;
    }

    public void dfs(int[] nums, List<Integer> combine, List<List<Integer>> resList, int index) {
        if (index == nums.length) {
            resList.add(new ArrayList<>(combine));
            return;
        }

        combine.add(nums[index]);
        dfs(nums, combine, resList, index + 1);
        combine.remove(combine.size() - 1);
        dfs(nums, combine, resList, index + 1);
    }
}
