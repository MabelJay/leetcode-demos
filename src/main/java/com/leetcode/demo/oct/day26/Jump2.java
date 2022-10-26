package com.leetcode.demo.oct.day26;

public class Jump2 {
    public static void main(String[] args) {
        // 输入: nums = [2,3,1,1,4]
        //输出: 2

        // 输入: nums = [2,3,0,1,4]
        //输出: 2
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Jump2().jump(nums));
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxLen = 0;
        int index = 0;
        int totalSteps = 0;
        int end = 0;
        while (index < nums.length - 1) {
            maxLen = Math.max(maxLen, nums[index] + index);
            if (index == end) {
                totalSteps++;
                end = maxLen;
            }
            index++;
        }
        return totalSteps;
    }
}
