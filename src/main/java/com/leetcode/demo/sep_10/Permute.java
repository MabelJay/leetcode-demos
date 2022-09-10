package com.leetcode.demo.sep_10;

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
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;

        List<Integer> combination = new ArrayList<>();
        for (int num : nums) {
            combination.add(num);
        }
        getPermute(list, combination, 0, nums.length);
        return list;
    }

    public void getPermute(List<List<Integer>> list, List<Integer> combination, int index, int len) {
        if (index == len) {
            list.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < len; i++) {
            Collections.swap(combination, index, i);
            getPermute(list, combination, index + 1, len);
            Collections.swap(combination, index, i);
        }
    }
}
