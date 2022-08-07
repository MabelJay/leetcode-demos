package com.leetcode.demo.easy.mar.mar_27;

import java.util.Arrays;

public class PivotIndex {

    public static void main(String[] args) {
        // 输入：nums = [1,7,3,6,5,6]
        //输出：3

        int[] nums = {1, 7, 3, 6, 5, 6};

        // 输入：nums = [1, 2, 3]
        //输出：-1
        int[] num2 = {1, 2, 3};

        // 输入：nums = [2, 1, -1]
        //输出：0
        int[] num3 = {2, 1, -1};
        System.out.println(new PivotIndex().pivotIndex(nums));
        System.out.println(new PivotIndex().pivotIndex(num2));
        System.out.println(new PivotIndex().pivotIndex(num3));

        System.out.println(new PivotIndex().pivotIndex2(nums));
        System.out.println(new PivotIndex().pivotIndex2(num2));
        System.out.println(new PivotIndex().pivotIndex2(num3));
    }

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] leftSum = new int[len + 1];
        int[] rightSum = new int[len + 1];

        leftSum[0] = 0;
        rightSum[len] = 0;

        for (int i = 0; i < len; i++) {
            leftSum[i + 1] = nums[i] + leftSum[i];
        }
//        System.out.println(Arrays.toString(leftSum));

        for (int i = len - 1; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
//        System.out.println(Arrays.toString(rightSum));
        for (int i = 0; i < len; i++) {
            if (leftSum[i + 1] == rightSum[i]) return i;
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
//        System.out.println("sum=" + sum);

        int preSum = 0;
        for (int i = 0; i < len; i++) {
            if (preSum == sum - preSum - nums[i]) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }
}
