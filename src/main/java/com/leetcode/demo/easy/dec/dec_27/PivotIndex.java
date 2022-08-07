package com.leetcode.demo.easy.dec.dec_27;

import java.util.Arrays;

public class PivotIndex {

    public static void main(String[] args) {
        //输入：nums = [1, 7, 3, 6, 5, 6]
        //输出：3

        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(new PivotIndex().pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int len = nums.length;
        int[] preSum = new int[len];
        int[] laterSum = new int[len];
        for (int i = 0; i < len; i++) {
            if (i > 0) preSum[i] = preSum[i - 1] + nums[i];
            else {
                preSum[i] = nums[i];
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                laterSum[i] = nums[i];
            } else {
                laterSum[i] = laterSum[i + 1] + nums[i];
            }
        }
//        System.out.println(Arrays.toString(preSum));
//        System.out.println(Arrays.toString(laterSum));
        for (int i = 0; i < len; i++) {
            if (preSum[i] == laterSum[i]) return i;
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
