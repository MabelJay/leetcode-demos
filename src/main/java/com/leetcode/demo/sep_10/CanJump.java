package com.leetcode.demo.sep_10;

public class CanJump {

    public static void main(String[] args) {
        // 输入：nums = [2,3,1,1,4]
        //输出：true

        // 输入：nums = [3,2,1,0,4]
        //输出：false

        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new CanJump().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int maxPos = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                end = maxPos;
            }
            if (end >= nums.length - 1) return true;
        }
        return false;
    }
}
