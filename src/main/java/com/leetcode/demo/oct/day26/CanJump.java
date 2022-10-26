package com.leetcode.demo.oct.day26;

public class CanJump {

    public static void main(String[] args) {
        // 输入：nums = [2,3,1,1,4]
        //输出：true

        // 输入：nums = [3,2,1,0,4]
        //输出：false

        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new CanJump().canJump2(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int index = 0;
        int maxPos = 0;
        int end = 0;

        while (index < nums.length - 1) {
            maxPos = Math.max(maxPos, nums[index] + index);
            if (maxPos >= nums.length - 1) return true;
            if (index == end) {
                if (end == maxPos) return false;
                end = maxPos;
            }
            index++;
        }
        return maxPos >= nums.length - 1;
    }

    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int maxPos = 0;
        int index = 0;
        while (index < nums.length) {
            if (index <= maxPos) {
                maxPos = Math.max(maxPos, nums[index] + index);
                if (maxPos >= nums.length - 1) return true;
            }
            index++;
        }
        return false;
    }
}
