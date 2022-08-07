package com.leetcode.demo.easy.jan.jan_2;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        // 输入：nums = [5,7,7,8,8,10], target = 8
        //输出：[3,4]

        int[] nums = {};
        System.out.println(Arrays.toString(new SearchRange().searchRange(nums, 5)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                int leftBoard = mid, rightBoard = mid;
                while (leftBoard >= 0 && nums[leftBoard] == nums[mid]) {
                    leftBoard--;
                }
                while (rightBoard < len && nums[rightBoard] == nums[mid]) {
                    rightBoard++;
                }
                return new int[]{leftBoard + 1, rightBoard - 1};
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
