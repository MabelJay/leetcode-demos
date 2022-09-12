package com.leetcode.demo.sep_12;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        // 输入：nums = [1,1,1,2,2,3]
        //输出：5, nums = [1,1,2,2,3]
        int[] nums = {1, 1, 1, 2, 2, 3};
        // 输入：nums = [0,0,1,1,1,1,2,3,3]
        //输出：7, nums = [0,0,1,1,2,3,3]
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};

        int[] nums3 = {1};
        System.out.println(new RemoveDuplicates().removeDuplicates2(nums3));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int left = 0, right = 0;
        int count = 0;
        while (right < nums.length - count) {
            while (right < nums.length && nums[right] == nums[left] && right - left < 2) {
                right++;
            }
            if (right < nums.length && nums[right] == nums[left]) {
                // move
                int temp = nums[left];
                int tmpIndex = right + 1;
                while (tmpIndex < nums.length) {
                    nums[tmpIndex - 1] = nums[tmpIndex];
                    tmpIndex++;
                }
                nums[nums.length - 1] = temp;
                count++;
            } else {
                left = right;
                right++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len <= 2) return len;

        int slow = 2, fast = 2;
        while (fast < len) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
