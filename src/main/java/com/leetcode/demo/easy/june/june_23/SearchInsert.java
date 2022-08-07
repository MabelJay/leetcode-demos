package com.leetcode.demo.easy.june.june_23;

public class SearchInsert {

    public static void main(String[] args) {
        // 输入: nums = [1,3,5,6], target = 5
        //输出: 2

        // 输入: nums = [1,3,5,6], target = 7
        //输出: 4
        int[] nums = {1, 3, 5, 6};
        System.out.println(new SearchInsert().searchInsert(nums, 2));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                if (mid == high) return high + 1;
                else low = mid + 1;
            } else if (nums[mid] > target) {
                if (mid == low) return low;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
