package com.leetcode.demo.apr.day25;

public class Rob2 {

    public static void main(String[] args) {
        // 输入：nums = [2,3,2]
        //输出：3

        // 输入：nums = [1,2,3,1]
        //输出：4

        // 输入：nums = [1,2,3]
        //输出：3

        int[] nums = {1, 2, 3, 1};
        System.out.println(new Rob2().rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robRange(0, len - 2, nums), robRange(1, len - 1, nums));
    }

    private int robRange(int start, int end, int[] nums) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int res = Math.max(first + nums[i], second);
            first = second;
            second = res;
        }
        return second;
    }
}
