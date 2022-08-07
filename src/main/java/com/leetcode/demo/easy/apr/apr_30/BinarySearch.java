package com.leetcode.demo.easy.apr.apr_30;

public class BinarySearch {
    public static void main(String[] args) {
        // 输入: nums = [-1,0,3,5,9,12], target = 9
        //输出: 4
        //解释: 9 出现在 nums 中并且下标为 4

        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(new BinarySearch().search(nums, 9));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
