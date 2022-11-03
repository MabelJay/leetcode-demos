package com.leetcode.demo.sep.day02;

public class CanJump1 {
    public static void main(String[] args) {
        // 输入：nums = [2,3,1,1,4]
        //输出：true

        // 输入：nums = [3,2,1,0,4]
        //输出：false

        // 0 false
        // 0 2 3
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new CanJump1().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) return true;

        int len = nums.length;
        int maxEnd = 0;
        for (int i = 0; i < len - 1; i++) {
            if (i <= maxEnd) {
                maxEnd = Math.max(maxEnd, nums[i] + i);
            }
            if (maxEnd >= len - 1) return true;
        }
        return false;
    }
}
