package com.leetcode.demo.easy.may.may_09;

import java.util.Arrays;

public class Exchange {

    public static void main(String[] args) {
        // 输入：nums = [1,2,3,4]
        //输出：[1,3,2,4]

        int[] nums = {1, 3, 5};
        System.out.println(Arrays.toString(new Exchange().exchange(nums)));
    }

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        return nums;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
