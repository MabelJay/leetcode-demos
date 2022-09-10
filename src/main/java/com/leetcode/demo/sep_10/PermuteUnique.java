package com.leetcode.demo.sep_10;

import java.util.*;

public class PermuteUnique {
    boolean[] visited;

    public static void main(String[] args) {
        // 输入：nums = [1,1,2]
        //输出：
        //[[1,1,2],
        // [1,2,1],
        // [2,1,1]]

        // 输入：nums = [1,2,3]
        //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        int[] nums = {1, 1, 2};
        System.out.println(new PermuteUnique().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;

        List<Integer> combine = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);

        getAllPermute(nums, list, combine, 0);
        return list;
    }

    public void getAllPermute(int[] nums, List<List<Integer>> list, List<Integer> combine, int index) {
        if (index == nums.length) {
            list.add(new ArrayList<>(combine));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            combine.add(nums[i]);
            visited[i] = true;
            getAllPermute(nums, list, combine, index + 1);
            visited[i] = false;
            combine.remove(index);
        }
    }
}
