package com.leetcode.demo.sep_10;

public class Jump {

    public static void main(String[] args) {
        //  nums = [2,3,1,1,4]
        // 2

        // 输入: nums = [2,3,0,1,4]
        //输出: 2

        //[7,0,9,6,9,6,1,7,9,0,1,2,9,0,3]
        // 2
        int[] nums = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(new Jump().jump(nums));
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int steps = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                steps++;
                end = maxPos;
            }
            if (end >= nums.length - 1) return steps;
        }
        return 0;
    }
}
