package com.leetcode.demo.easy.jan.jan_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3]
        //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        int[] nums = {1, 2, 3};
        System.out.println(new Permute().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length == 0) return resList;

        List<Integer> output = new ArrayList<>();
        for (int val : nums) {
            output.add(val);
        }
        dfs(output, nums.length, resList, 0);
        return resList;
    }

    public void dfs(List<Integer> output, int len, List<List<Integer>> resList, int index) {
        if (index == len) {
            resList.add(new ArrayList<>(output));
        }

        for (int i = index; i < len; i++) {
            Collections.swap(output, index, i);
            dfs(output, len, resList, index + 1);
            Collections.swap(output, index, i);
        }
    }
}
