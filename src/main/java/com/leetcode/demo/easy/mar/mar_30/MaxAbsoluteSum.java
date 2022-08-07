package com.leetcode.demo.easy.mar.mar_30;

import java.util.Arrays;
import java.util.Map;

public class MaxAbsoluteSum {

    public static void main(String[] args) {
        // 输入：nums = [1,-3,2,3,-4]
        //输出：5
        int[] nums = {1, -3, 2, 3, -4};

        // 输入：nums = [2,-5,1,-4,3,-2]
        //输出：8

        int[] num2 = {2, -5, 1, -4, 3, -2};

        // [-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9]
        // 44
        int[] num3 = {-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9};
        // [-3,-5,-3,-2,-6,3,10,-10,-8,-3,0,10,3,-5,8,7,-9,-9,5,-8]
        int[] num4 = {-3, -5, -3, -2, -6, 3, 10, -10, -8, -3, 0, 10, 3, -5, 8, 7, -9, -9, 5, -8};

        // [6,-4,8,7,-7,3,1,3,0,-3,6,-7,-4,-4,-6,-2,-3,-1,10,-2]
        int[] num5 = {6, -4, 8, 7, -7, 3, 1, 3, 0, -3, 6, -7, -4, -4, -6, -2, -3, -1, 10, -2};

        int[] num6 = {-1};
//        System.out.println(new MaxAbsoluteSum().maxAbsoluteSum2(nums));
//        System.out.println(new MaxAbsoluteSum().maxAbsoluteSum2(num2));
        System.out.println(new MaxAbsoluteSum().maxAbsoluteSum3(num3));
//        System.out.println(new MaxAbsoluteSum().maxAbsoluteSum(num4));
//        System.out.println(new MaxAbsoluteSum().maxAbsoluteSum(num5));
//        System.out.println(new MaxAbsoluteSum().maxAbsoluteSum(num6));
    }

    // 前缀和
    public int maxAbsoluteSum(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        int max = Math.abs(nums[0]);
        int index = -1;
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + nums[i];
            if (Math.abs(dp[i]) > max) {
                max = Math.abs(dp[i]);
                index = i;
            }
        }
        int res = max;
        for (int i = 0; i < len && index != -1; i++) {
            res = Math.max(res, Math.abs(dp[index] - dp[i]));
        }
        return res;
    }

    // 动态规划
    public int maxAbsoluteSum2(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];

        dp[0] = new int[]{nums[0], nums[0]}; // min, max
        int maxAns = Math.abs(nums[0]);
        for (int i = 1; i < len; i++) {
            // dp[i][0] 表示以 nums[i] 结尾和最小的子数组
            dp[i][0] = Math.min(nums[i], dp[i - 1][0] + nums[i]);
            // dp[i][1] 表示以 nums[i] 结尾和最大的子数组
            dp[i][1] = Math.max(nums[i], dp[i - 1][1] + nums[i]);
            printMatrix(dp);
            maxAns = Math.max(maxAns, Math.abs(dp[i][0]));
            maxAns = Math.max(maxAns, Math.abs(dp[i][1]));
        }

        return maxAns;
    }

    public int maxAbsoluteSum3(int[] nums) {
        int len = nums.length;
        int minPre = nums[0];
        int maxPre = nums[0];

        int maxAns = Math.abs(nums[0]);
        for (int i = 1; i < len; i++) {
            minPre = Math.min(minPre + nums[i], nums[i]);
            maxPre = Math.max(maxPre + nums[i], nums[i]);
            maxAns = Math.max(maxAns, Math.abs(minPre));
            maxAns = Math.max(maxAns, Math.abs(maxPre));
        }

        return maxAns;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
