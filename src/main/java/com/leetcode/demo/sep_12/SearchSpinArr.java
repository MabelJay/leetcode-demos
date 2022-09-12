package com.leetcode.demo.sep_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSpinArr {

    public static void main(String[] args) {
        // 输入：nums = [2,5,6,0,0,1,2], target = 0
        //输出：true

        int[] nums = {5, 1, 3};
        // 输入：nums = [2,5,6,0,0,1,2], target = 3
        //输出：false
        // [1,0,1,1,1]
        //0
        List<int[]> list = getAllArrays(nums);
        SearchSpinArr searchSpinArr = new SearchSpinArr();
        list.forEach(val -> {
            System.out.println(Arrays.toString(val));
            System.out.println(searchSpinArr.search(val, 3));
            System.out.println();
        });
    }

    private static List<int[]> getAllArrays(int[] arr) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int[] tmpArr = new int[arr.length];
            int index = 0;
            for (int j = i; j < arr.length; j++) {
                tmpArr[index++] = arr[j];
            }
            for (int k = 0; k < i; k++) {
                tmpArr[index++] = arr[k];
            }
            list.add(tmpArr);
        }
        return list;
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return true;

            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && nums[nums.length - 1] >= target) {
                    left = mid + 1;
                } else right = mid - 1;
            }
        }
        return false;
    }
}
