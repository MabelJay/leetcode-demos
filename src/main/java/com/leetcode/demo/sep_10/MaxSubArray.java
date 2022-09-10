package com.leetcode.demo.sep_10;

public class MaxSubArray {

    public static void main(String[] args) {
        // 输入：nums = [-2,-3,-1, -5]

        // 输入：nums = [5,4,-1,7,8]
        //输出：23

        int[] nums = {-2,-3,-1, -5};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int res = 0;
        for (int num : nums) {
            res += num;
            maxSum = Math.max(maxSum, res);
            if (res < 0) {
                res = 0;
            }
        }
        return maxSum;
    }
}
