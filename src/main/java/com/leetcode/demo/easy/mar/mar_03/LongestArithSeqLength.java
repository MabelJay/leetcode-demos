package com.leetcode.demo.easy.mar.mar_03;

import java.util.HashMap;
import java.util.Map;

public class LongestArithSeqLength {
    public static void main(String[] args) {
        // 输入：nums = [9,4,7,2,10]
        //输出：3
        //解释：
        //最长的等差子序列是 [4,7,10]。
        int[] nums = {9, 4, 7, 2, 10};
        System.out.println(new LongestArithSeqLength().longestArithSeqLength2(nums));
    }

    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        int ans = 0;
        int[][] dp = new int[len][1001];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 500;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                ans = Math.max(ans, dp[i][diff]);
            }
        }
        return ans + 1;
    }

    public int longestArithSeqLength2(int[] nums) {
        int len = nums.length;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int diff = nums[j] - nums[i];
                int count = 1;
                int start = nums[j];
                for (int k = j + 1; k < len; k++) {
                    if (nums[k] - start == diff) {
                        count++;
                        start = nums[k];
                    }
                }
                maxLen = Math.max(count, maxLen);
            }
        }
        return maxLen + 1;
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
