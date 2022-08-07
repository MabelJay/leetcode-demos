package com.leetcode.demo.easy.may.may_16;

public class SearchInArray {

    public static void main(String[] args) {
        // 输入: nums = [5,7,7,8,8,10], target = 8
        //输出: 2

        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(new SearchInArray().search(nums, 6));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;

        int low = 0, high = nums.length - 1;
        int count = 0;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (target == nums[mid]) {
                // expand to two ways
                int leftIndex = mid, rightIndex = mid;
                while (leftIndex >= 0 && nums[leftIndex] == target) {
                    leftIndex--;
                }

                while (rightIndex < nums.length && nums[rightIndex] == target) {
                    rightIndex++;
                }
                return rightIndex - leftIndex - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return count;
    }
}
