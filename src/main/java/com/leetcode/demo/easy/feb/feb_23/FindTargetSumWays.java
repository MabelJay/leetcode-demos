package com.leetcode.demo.easy.feb.feb_23;

public class FindTargetSumWays {

    int count = 0;

    public static void main(String[] args) {
        // 输入：nums = [1,1,1,1,1], target = 3
        //输出：5

        // [1]
        //2

        // [7,9,3,8,0,2,4,8,3,9]
        //0
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(new FindTargetSumWays().findTargetSumWays(nums, 3));
        System.out.println(new FindTargetSumWays().findTargetSumWays2(nums, 3));
        System.out.println(new FindTargetSumWays().findTargetSumWays3(nums, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, nums.length - 1);
        return count;
    }

    public void dfs(int[] nums, int target, int index) {
        if (index < 0) {
            if (target == 0) {
                count++;
            }
            return;
        }

        dfs(nums, target - nums[index], index - 1);
        dfs(nums, target + nums[index], index - 1);
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) return 0;
        int len = nums.length;
        int columns = diff / 2 + 1;
        int[][] dp = new int[len + 1][columns];
        dp[0][0] = 1;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < columns; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][columns - 1];
    }

    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) return 0;
        int columns = diff / 2;
        int[] dp = new int[columns + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = columns; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[columns];
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
