package com.leetcode.demo.apr.day20;

public class CanJump {

    public static void main(String[] args) {
        // 输入：nums = [2,3,1,1,4]
        //输出：true

        // 输入：nums = [3,2,1,0,4]
        //输出：false

        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new CanJump().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) return true;

        int index = 0;
        int maxEnd = 0;
        int len = nums.length;
        while (index < len) {
            if (maxEnd < index) return false;
            maxEnd = Math.max(maxEnd, nums[index] + index);
            if (maxEnd >= len - 1) return true;
            index++;
        }
        return false;
    }
}
