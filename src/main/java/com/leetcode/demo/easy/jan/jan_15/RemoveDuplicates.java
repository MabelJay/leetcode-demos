package com.leetcode.demo.easy.jan.jan_15;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        // 输入：nums = [1,1,1,2,2,3]
        //输出：5, nums = [1,1,2,2,3]

        // 输入：nums = [0,0,1,1,1,1,2,3,3]
        //输出：7, nums = [0,0,1,1,2,3,3]
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(new RemoveDuplicates().removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int len = nums.length;
        int left = 1, right = len - 1;
        int start = 0;
        while (left <= right) {
            int count = 1;
            while (left <= right && nums[left] == nums[left - 1]) {
                count++;
                left++;
            }
            if (count > 2) {
                start += 2;
                while (left <= right) {
                    nums[left - count + 2] = nums[left];
                    left++;
                }
                right = left - count + 1;
                left = start;
            } else {
                left++;
            }
        }
        return right + 1;
    }

    public int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if (len < 3) return len;

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
