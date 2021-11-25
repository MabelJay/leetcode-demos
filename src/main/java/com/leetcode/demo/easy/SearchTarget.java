package com.leetcode.demo.easy;

import java.util.Arrays;

public class SearchTarget {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int[] arr1 = {1};
        System.out.println(new SearchTarget().searchInsert2(arr, 0));
//        System.out.println(new SearchTarget().searchInsert(arr1, 0));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        int center;
        while (left <= right) {
            center = (left + right) >> 1;
            if (nums[center] == target) return center;
            else if (nums[center] < target) {
                left = center + 1;
            } else {
                right = center - 1;
            }
        }
        return left;
    }

    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
