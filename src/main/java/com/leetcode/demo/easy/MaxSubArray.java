package com.leetcode.demo.easy;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr2 = {0};
        int[] arr3 = {-2, -1};
        System.out.println(new MaxSubArray().maxSubArray1(arr));
    }

    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int thisSum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            thisSum += num;
            if (thisSum > maxSum) {
                maxSum = thisSum;
            }
            if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        return maxSumRec(nums, 0, nums.length - 1);

    }

    public int maxSumRec(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }

        int center = (left + right) >> 1;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBoarderSum = Integer.MIN_VALUE, leftBoarderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBoarderSum += a[i];
            if (leftBoarderSum > maxLeftBoarderSum) {
                maxLeftBoarderSum = leftBoarderSum;
            }
        }

        int maxRightBoarderSum = Integer.MIN_VALUE, rightBoarderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBoarderSum += a[i];
            if (rightBoarderSum > maxRightBoarderSum) maxRightBoarderSum = rightBoarderSum;
        }
        return max3Num(maxLeftSum, maxRightSum, maxLeftBoarderSum + maxRightBoarderSum);
    }

    private int max3Num(int num1, int num2, int num3) {
        int maxNum = num1;
        if (num2 > maxNum) maxNum = num2;
        if (num3 > maxNum) maxNum = num3;
        return maxNum;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
