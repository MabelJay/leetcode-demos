package com.leetcode.demo.easy.jan.jan_5;

import java.util.ArrayList;
import java.util.List;

public class SearchInReShapedArr {

    public static void main(String[] args) {
        //输入：nums = [4,5,6,7,0,1,2], target = 0
        //输出：4

        // [[0, 1, 2, 4, 5, 6, 7], [1, 2, 4, 5, 6, 7 , 0], [2, 4, 5, 6, 7, 0, 1], [4, 5, 6, 7, 0, 1, 2], [5, 6, 7, 0, 1, 2, 4], [6, 7, 0, 1, 2, 4, 5], [7, 0, 1, 2, 4, 5, 6]]
        int[] nums = {1, 3, 5};
        // [4,5,6,7,0,1,2]
        //0
        System.out.println(new SearchInReShapedArr().search(nums, 1));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[len - 1] >= target && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public List<List<Integer>> getAllTransformedArr(int[] arr) {
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                list.add(arr[j]);
            }
            int k = 0;
            while (k < i) {
                list.add(arr[k]);
                k++;
            }
            resList.add(list);
        }
        return resList;
    }
}
