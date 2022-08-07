package com.leetcode.demo.easy.may.may_16;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        // 输入：nums = [5,7,7,8,8,10], target = 8
        //输出：[3,4]

        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new SearchRange().searchRange(nums, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) {
                // expand

                int leftIndex = mid;
                int rightIndex = mid;

                while (leftIndex >= 0 && nums[leftIndex] == target) {
                    leftIndex--;
                }
                while (rightIndex < nums.length && nums[rightIndex] == target) {
                    rightIndex++;
                }
                return new int[]{leftIndex + 1, rightIndex - 1};
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
