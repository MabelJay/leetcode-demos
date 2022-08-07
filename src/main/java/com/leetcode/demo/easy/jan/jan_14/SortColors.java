package com.leetcode.demo.easy.jan.jan_14;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        // 输入：nums = [2,0,2,1,1,0]
        //输出：[0,0,1,1,2,2]

        int[] nums = {2, 0, 1};
        int[] nums2 = {1, 0, 1, 1, 2, 0};
        new SortColors().sortColors(nums2);
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int len = nums.length;
        int small = 0, large = len - 1;
        int cur = 0;
        while (cur <= large) {
            if (nums[cur] < 1) {
                swap(nums, cur++, small++);
            } else if (nums[cur] > 1) {
                swap(nums, large--, cur);
            } else {
                cur++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
