package com.leetcode.demo.sep.day02;

public class Jump {
    public static void main(String[] args) {
        // 输入: nums = [2,3,1,1,4]
        //输出: 2
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Jump().jump(nums));
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int steps = 0;
        int end = 0;
        int maxEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxEnd = Math.max(maxEnd, i + nums[i]);
            if (i == end) {
                steps++;
                end = maxEnd;
            }
        }
        return steps;
    }
}
