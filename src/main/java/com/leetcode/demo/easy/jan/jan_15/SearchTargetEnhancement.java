package com.leetcode.demo.easy.jan.jan_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTargetEnhancement {

    public static void main(String[] args) {
        // 输入：nums = [2,5,6,0,0,1,2], target = 0
        //输出：true

        // 0, 0, 1, 2, 2, 5, 6

        int[] nums = {2,5,6,0,0,1,2};
        List<int[]> res = new SearchTargetEnhancement().generateAllReshapedWords(nums);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
            System.out.println(new SearchTargetEnhancement().search(arr, 0));
        }

        // [1,0,1,1,1]
        //0

        // [1, 1, 1, 0, 1]
        // false
        int[] nums2 = {1, 1, 1, 0, 1};
        System.out.println(new SearchTargetEnhancement().search(nums2, 0));
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) return true;
            if (nums[low] == nums[mid] && nums[high] == nums[mid]) {
                low++;
                high--;
            } else if (nums[low] > nums[mid]) {
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid] > target && nums[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }


    public List<int[]> generateAllReshapedWords(int[] arr) {
        List<int[]> resList = new ArrayList<>();
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int[] tmpArr = new int[len];
            int index = 0;
            for (int j = i; j < len; j++) {
                tmpArr[index++] = arr[j];
            }
            int k = 0;
            while (k < i) {
                tmpArr[index++] = arr[k];
                k++;
            }
            resList.add(tmpArr);
        }
        return resList;
    }
}
