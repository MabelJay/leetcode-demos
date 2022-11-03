package com.leetcode.demo.sep.day03;

public class CanJump {

    public static void main(String[] args) {
        // 输入：nums = [2,3,1,1,4]
        //输出：true

        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new CanJump().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) return true;

        int maxEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i <= maxEnd) {
                maxEnd = Math.max(maxEnd, nums[i] + i);
            }
            if (maxEnd >= nums.length - 1) return true;
        }
        return false;
    }
}
