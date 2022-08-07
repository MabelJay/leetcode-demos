package com.leetcode.demo.easy.may.may_03;

public class CanJump {

    public static void main(String[] args) {
        // 输入：nums = [2,3,1,1,4]
        //输出：true

        // 输入：nums = [3,2,1,0,4]
        //输出：false

        int[] nums = {2,3,1,1,4};

        // [2,0]

        // [0,2,3]
        //false
        System.out.println(new CanJump().canJump2(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int len = nums.length;
        return jump(nums, len - 1);
    }

    public boolean jump(int[] nums, int j) {
        if (j == 0) return true;
        for (int i = j - 1; i >= 0; i--) {
            if (nums[i] >= j - i) {
                return jump(nums, i);
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        if (nums.length == 1) return true;

        int pos = 0, maxPos = 0;
        while (pos < nums.length - 1) {
            maxPos = Math.max(maxPos, pos + nums[pos]);
            if (maxPos >= nums.length - 1) return true;
            pos++;
            if (pos > maxPos) return false;
        }
        return false;
    }
}
