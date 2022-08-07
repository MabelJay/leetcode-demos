package com.leetcode.demo.easy.june.june_16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        // 输入：nums = [1,2,3]
        //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        // 输入：nums = [0,1]
        //输出：[[0,1],[1,0]]

        int[] nums = {1, 2, 3};
        System.out.println(new Permute().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        for (int num : nums) {
            combine.add(num);
        }
        dfs(nums.length, 0, list, combine);
        return list;
    }

    public void dfs(int len, int index, List<List<Integer>> list, List<Integer> combine) {
        if (index == len) {
            list.add(new ArrayList<>(combine));
        }

        for (int i = index; i < len; i++) {
            Collections.swap(combine, index, i);
            dfs(len, index + 1, list, combine);
            Collections.swap(combine, index, i);
        }
    }
}
