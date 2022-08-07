package com.leetcode.demo.easy.dec.dec_30;

public class IsMonotonic {
    public static void main(String[] args) {
        // 输入：[1,2,2,3]
        //输出：true
        int[] nums = {1, 1, 4};
        System.out.println(new IsMonotonic().isMonotonic2(nums));
    }

    public boolean isMonotonic(int[] nums) {
        int len = nums.length;
        boolean asc = nums[len - 1] >= nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (asc) {
                if (nums[i] < nums[i - 1]) return false;
            } else {
                if (nums[i] > nums[i - 1]) return false;
            }
        }
        return true;
    }

    public boolean isMonotonic2(int[] nums) {
        boolean asc = true;
        boolean desc = true;
        for (int i = 1; i < nums.length; i++) {
           if (nums[i]<nums[i-1])asc = false;
           if (nums[i]>nums[i-1])desc = false;
        }
        return asc || desc;
    }
}
