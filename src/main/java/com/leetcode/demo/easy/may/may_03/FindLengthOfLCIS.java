package com.leetcode.demo.easy.may.may_03;

public class FindLengthOfLCIS {

    public static void main(String[] args) {
        // 输入：nums = [1,3,5,4,7]
        //输出：3

        // 输入：nums = [1,3,5,4,7]
        //输出：3

        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(nums));
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS2(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public int findLengthOfLCIS2(int[] nums) {
        int maxLen = 1, start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) start = i;
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}
