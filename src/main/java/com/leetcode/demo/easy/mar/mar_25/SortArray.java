package com.leetcode.demo.easy.mar.mar_25;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        // 输入：nums = [5,1,1,2,0,0]
        //输出：[0,0,1,1,2,5]

        int[] nums = {5, 1, 1, 2, 0, 0};
//        System.out.println(Arrays.toString(new SortArray().sortArray(nums)));
        System.out.println(Arrays.toString(new SortArray().sortArray3(nums)));
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        for (int j = 1; j < nums.length; j++) {
            int temp = nums[j];
            int i = j - 1;

            while (i >= 0 && nums[i] > temp) {
                nums[i + 1] = nums[i];
                i--;
            }
            nums[i + 1] = temp;
        }
        return nums;
    }

    public int[] sortArray3(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortArray2(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[left];
            int i = left, j = right;

            while (i < j) {
                while (i < j && arr[j] >= pivot) {
                    j--;
                }
                arr[i] = arr[j];

                while (i < j && arr[i] < pivot) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = pivot;
            quickSort(arr, left, i);
            quickSort(arr, i + 1, right);
        }
    }
}
