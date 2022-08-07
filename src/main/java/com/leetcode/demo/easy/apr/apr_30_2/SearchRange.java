package com.leetcode.demo.easy.apr.apr_30_2;

import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        // 输入：nums = [5,7,7,8,8,10], target = 8
        //输出：[3,4]

        // 输入：nums = [5,7,7,8,8,10], target = 6
        //输出：[-1,-1]

        int[] nums = {5, 5, 7, 7, 8, 8, 10, 10};
        System.out.println(Arrays.toString(new SearchRange().searchRange(nums, 10)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                // expand
                low = mid;
                high = mid;
                while (low >= 0 && nums[low] == nums[mid]) {
                    low--;
                }
                while (high < nums.length && nums[high] == nums[mid]) {
                    high++;
                }
                return new int[]{low + 1, high - 1};
            } else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return new int[]{-1, -1};
    }
}
