package com.leetcode.demo.sep_03;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        // 输入：nums = [1,2,3]
        //输出：[1,3,2]

        // 输入：nums = [3,2,1]
        //输出：[1,2,3]

        int[] nums = {2, 3, 1, 3, 3};
        // [1,3,2]
        // [2,3,1,3,3]
        // [2,3,3,1,3]
        new NextPermutation().nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int right = nums.length - 1;
        while (right > 0 && nums[right] <= nums[right - 1]) {
            right--;
        }
        if (right == 0) {
            Arrays.sort(nums);
            return;
        }

        int tempIndex = right - 1;
        right = nums.length - 1;
        while (right > tempIndex && nums[right] <= nums[tempIndex]) {
            right--;
        }
        swap(nums, tempIndex, right);
        reverse(nums, tempIndex + 1, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void sortPartArr(int[] arr, int i, int j) {
        for (int index1 = i + 1; index1 <= j; index1++) {
            int temp = arr[index1];
            int index2 = index1 - 1;

            while (index2 >= i && arr[index2] > temp) {
                arr[index2 + 1] = arr[index2];
                index2--;
            }
            arr[index2 + 1] = temp;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left++, right--);
        }
    }
}
