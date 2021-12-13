package com.leetcode.demo.easy;

import java.util.Arrays;

public class MinMoves {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new MinMoves().minMoves(arr));
    }

    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }
}
