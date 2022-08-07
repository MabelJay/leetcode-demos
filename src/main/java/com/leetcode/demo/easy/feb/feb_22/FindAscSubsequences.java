package com.leetcode.demo.easy.feb.feb_22;

import java.util.ArrayList;
import java.util.List;

public class FindAscSubsequences {

    public static void main(String[] args) {
        // 输入：nums = [4,6,7,7]
        //输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
        // [[4, 6, 7, 7], [4, 6, 7], [4, 6], [4, 7, 7], [4, 7], [6, 7, 7], [6, 7], [7, 7]]
        int[] nums = {4, 6, 7, 7};
        System.out.println(new FindAscSubsequences().findSubsequences(nums));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        dfs(list, nums, new ArrayList<>(), 0);
        return list;
    }


    public void dfs(List<List<Integer>> list, int[] nums, List<Integer> combine, int index) {
        if (index == nums.length) {
            if (combine.size() > 1) {
                list.add(new ArrayList<>(combine));
            }
            return;
        }

        if (combine.size() == 0 || nums[index] >= combine.get(combine.size() - 1)) {
            combine.add(nums[index]);
            dfs(list, nums, combine, index + 1);
            combine.remove(combine.size() - 1);
        }
        if (combine.size()==0 || nums[index] != combine.get(combine.size() - 1)) {
            dfs(list, nums, combine, index + 1);
        }
    }
}
