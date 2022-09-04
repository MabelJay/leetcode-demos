package com.leetcode.demo.sep_04;

public class SearchInsert {

    public static void main(String[] args) {
        // 输入: nums = [1,3,5,6], target = 5
        //输出: 2

        int[] nums = {1, 3, 5};
        System.out.println(new SearchInsert().searchInsert2(nums, 1));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            nums = new int[1];
            nums[0] = target;
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                if (mid > 0 && nums[mid - 1] < target) return mid;
                if (mid == 0) return 0;
                else right = mid - 1;
            } else {
                if (mid < nums.length - 1 && nums[mid + 1] > target) return mid + 1;
                if (mid == nums.length - 1) return nums.length;
                else left = mid + 1;
            }
        }
        return -1;
    }

    public int searchInsert2(int[] nums, int target) {
        if (nums == null) return -1;
        int ans = nums.length;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }
}
