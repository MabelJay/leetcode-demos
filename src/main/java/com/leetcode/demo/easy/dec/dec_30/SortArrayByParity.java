package com.leetcode.demo.easy.dec.dec_30;

import com.leetcode.demo.easy.AddDigits;

import java.util.Arrays;

public class SortArrayByParity {

    public static void main(String[] args) {
        // 输入：[3,1,2,4]
        //输出：[2,4,3,1]
        //输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
        int[] nums = {3, 1, 2, 4};
        int[] nums2 = {4, 12, 1, 3};
        System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(nums2)));
    }

    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 != 0) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
                left++;
                right--;
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
