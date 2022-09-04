package com.leetcode.demo.sep_04;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        // 输入：nums = [5,7,7,8,8,10], target = 8
        //输出：[3,4]

        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new SearchRange().searchRange(nums, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                int indexLeft = mid - 1, indexRight = mid + 1;
                while (indexLeft >= 0 && nums[indexLeft] == target) {
                    indexLeft--;
                }
                while (indexRight < nums.length && nums[indexRight] == target) {
                    indexRight++;
                }
                return new int[]{indexLeft + 1, indexRight - 1};
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
