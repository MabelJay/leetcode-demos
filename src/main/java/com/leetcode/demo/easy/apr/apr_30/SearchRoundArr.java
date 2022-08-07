package com.leetcode.demo.easy.apr.apr_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRoundArr {

    public static void main(String[] args) {
        // 输入：nums = [4,5,6,7,0,1,2], target = 0
        //输出：4
        int[] nums = {0, 1, 2, 4, 5, 6, 7};

        // -1
        //[1, 2, 4, 5, 6, 7, 0]
        int[] nums2 = {1, 2, 4, 5, 6, 7, 0};
        System.out.println(new SearchRoundArr().search(nums2, 4));
        List<int[]> list = new SearchRoundArr().getAllArr(nums);
        System.out.println();
        for (int[] arr : list) {
            System.out.println(new SearchRoundArr().search(arr, 4));
            System.out.println(Arrays.toString(arr));
        }
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (target <= nums[mid] && nums[0] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && nums[nums.length - 1] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public List<int[]> getAllArr(int[] nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int[] tmpArr = new int[nums.length];
            int index = 0;
            for (int j = i; j < nums.length; j++) {
                tmpArr[index++] = nums[j];
            }
            for (int k = 0; k < i; k++) {
                tmpArr[index++] = nums[k];
            }
            list.add(tmpArr);
        }
        return list;
    }
}
