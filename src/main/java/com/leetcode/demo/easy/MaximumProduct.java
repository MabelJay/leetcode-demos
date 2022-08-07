package com.leetcode.demo.easy;

import java.util.Arrays;

public class MaximumProduct {

    public static void main(String[] args) {

        //[-100,-98,-1,2,3,4]
        int[] nums = {-100, -98, -1, 2, 3, 4};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(new MaximumProduct().maximumProduct3(nums));
    }

    // O(n*n*n)
    public int maximumProduct2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxNum = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    int val = nums[i] * nums[j] * nums[k];
                    maxNum = Math.max(maxNum, val);
                }
            }
        }
        return maxNum;
    }

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }

    public int maximumProduct3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
