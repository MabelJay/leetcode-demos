package com.leetcode.demo.sep_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRotateArr {

    public static void main(String[] args) {
        // 输入：nums = [4,5,6,7,0,1,2], target = 0
        //输出：4

        //输入：nums = [4,5,6,7,0,1,2], target = 3
        //输出：-1

        int[] nums = {0, 1, 2, 4, 5, 6, 7};
        for (int[] arr : new SearchRotateArr().getAllArr(nums)) {
            System.out.println(Arrays.toString(arr));
        }

        int[] nums2 = {3, 1};
        System.out.println(new SearchRotateArr().search(nums2, 1));
    }

    public List<int[]> getAllArr(int[] nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int[] arr = new int[nums.length];
            int index = 0;
            while (j < nums.length) {
                arr[index++] = nums[j];
                j++;
            }
            for (int k = 0; k < i; k++) {
                arr[index++] = nums[k];
            }
            list.add(arr);
        }
        return list;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[0]) {
                if (nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
