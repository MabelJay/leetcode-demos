package com.leetcode.demo.easy.jan.jan_31;

public class Rob2 {

    public static void main(String[] args) {
        // 输入：nums = [2,3,2]
        //输出：3

        // 输入：nums = [1,2,3,1]
        //输出：4

        // [1,1,1,2]

        // [2,1,1,2]
        // 3

        int[] nums = {2, 3, 2};
        System.out.println(new Rob2().rob3(nums));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len < 2) return nums[0];
        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = 0;
        for (int i = 2; i < len; i++) {
            if (i == 2) dp[i] = nums[i] + dp[0];
            if (i == len - 1) dp[i] = Math.max(dp[i - 1], dp[i - 2]);
            else dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        max = dp[len - 1];

        dp[1] = nums[1];
        for (int i = 2; i < len; i++) {
            if (i == 2) dp[i] = Math.max(dp[i - 1], nums[i]);
            else dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        max = Math.max(max, dp[len - 1]);
        return max;
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        if (len < 2) return nums[0];

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int cur = Math.max(first, second);
        for (int i = 2; i < len; i++) {
            if (i == 2) cur = first + nums[2];
            if (i == len - 1) cur = Math.max(first, second);
            else {
                cur = Math.max(first + nums[i], second);
            }
            first = second;
            second = cur;
        }
        int max = cur;
        first = nums[0];
        second = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i == 2) cur = Math.max(second, nums[2]);
            else {
                cur = Math.max(first + nums[i], second);
            }
            first = second;
            second = cur;
        }
        max = Math.max(cur, max);
        return max;
    }

    public int rob3(int[] nums) {
        int len = nums.length;
        if (len < 2) return nums[0];
        else if (len == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        int cur = 0;
        for (int i = start + 2; i <= end; i++) {
            cur = Math.max(first + nums[i], second);
            first = second;
            second = cur;
        }
        return second;
    }
}
