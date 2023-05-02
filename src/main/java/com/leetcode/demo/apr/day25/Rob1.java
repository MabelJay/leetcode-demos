package com.leetcode.demo.apr.day25;

public class Rob1 {

    public static void main(String[] args) {
        // 输入：[1,2,3,1]
        //输出：4

        // 输入：[2,7,9,3,1]
        //输出：12

        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Rob1().rob2(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        if (len == 1) return nums[0];
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            int res = Math.max(first + nums[i], second);
            first = second;
            second = res;
        }
        return second;
    }
}
