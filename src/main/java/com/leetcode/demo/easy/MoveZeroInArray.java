package com.leetcode.demo.easy;

import java.util.Arrays;

public class MoveZeroInArray {

    public static void main(String[] args) {

        // 输入: [1,1,2,0,12]
        //输出: [1,3,12,0,0]

        int[] nums = {1, 1, 2, 0, 12};
        new MoveZeroInArray().moveZeroes3(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int i, temp;

        for (int j = 1; j < nums.length; ) {
            if (nums[j] == 0) {
                j++;
                continue;
            }
            temp = nums[j];
            i = j - 1;

            while (i >= 0 && nums[i] == 0) {
                nums[i + 1] = nums[i];
                i--;
            }
            nums[i + 1] = temp;
            j++;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int len = nums.length;
        int left = 0, right = 0;

        while (right < len) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void moveZeroes3(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, right = 0;
        int len = nums.length;
        while (right < len) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
            right++;
        }
        for (int i = left; i < len; i++) {
            nums[i] = 0;
        }
    }
}
