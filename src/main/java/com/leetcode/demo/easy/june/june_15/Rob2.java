package com.leetcode.demo.easy.june.june_15;

public class Rob2 {

    int maxNum;

    public static void main(String[] args) {
        // 输入：nums = [1,2,3,1]
        //输出：4

        // 输入：nums = [2,7,9,3,1]
        //输出：12

        int[] nums = {1, 2, 3, 1};
        System.out.println(new Rob2().rob3(nums));
    }

    public int rob(int[] nums) {
        maxNum = Integer.MIN_VALUE;
        dfs(nums, 0, 0);
        return maxNum;
    }

    public void dfs(int[] nums, int index, int sum) {
        if (index >= nums.length) return;
        sum += nums[index];
        maxNum = Math.max(maxNum, sum);
        dfs(nums, index + 2, sum);
        dfs(nums, index + 1, sum - nums[index]);
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    public int rob3(int[] nums) {
        int first = 0;
        int second = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(second, first + nums[i]);
            first = second;
            second = temp;
        }
        return second;
    }
}
