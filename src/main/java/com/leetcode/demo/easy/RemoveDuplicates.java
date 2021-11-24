package com.leetcode.demo.easy;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicates().removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int duplicates = 0;
        int len = nums.length;
        for (int j = 0; j < len - duplicates; j++) {
            for (int i = j + 1; i < len - duplicates; i++) {
                if (nums[i] == nums[j]) {
                    duplicates++;
                    swap(nums, i, len - duplicates);
                }
            }
        }
        return len - duplicates;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int fast = 1, slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
