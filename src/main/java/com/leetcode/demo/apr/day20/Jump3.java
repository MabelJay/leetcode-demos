package com.leetcode.demo.apr.day20;

public class Jump3 {

    public static void main(String[] args) {
        // 输入: nums = [2,3,1,1,4]
        //输出: 2
        int[] nums = {1};
        System.out.println(new Jump3().jump(nums));
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int steps = 0;
        int end = 0;
        int maxRight = 0;
        int index = 0;

        while (index < nums.length - 1) {
            maxRight = Math.max(maxRight, nums[index] + index);
            if (index == end) {
                steps++;
                end = maxRight;
            }
            index++;
        }
        return steps;
    }
}
