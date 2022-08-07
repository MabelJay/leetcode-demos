package com.leetcode.demo.easy.apr.apr_28;

import com.leetcode.demo.easy.feb.feb_01.FindOrder;

import java.util.Arrays;

public class FindPeakElement {

    public static void main(String[] args) {
        // 输入：nums = [1,2,3,1]
        //输出：2

        int[] nums = {1,2,1,3,5,6,4};
        // 输入：nums = [1,2,1,3,5,6,4]
        //输出：1 或 5

        // [-2147483648,-2147483647]
        System.out.println(new FindPeakElement().findPeakElement2(nums));
    }

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            left[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int j = len - 1; j >= 0; j--) {
            max = Math.max(max, nums[j]);
            right[j] = max;
        }

        for (int i = 0; i < len; i++) {
            if (left[i] == right[i]) return i;
        }
        return -1;
    }

    public int findPeakElement2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) return mid;
                left = mid + 1;
            } else if (mid == len - 1) {
                if (nums[mid] > nums[mid - 1]) return mid;
                right = mid - 1;
            } else {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
                else if (nums[mid] > nums[mid - 1]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    //  if (nums == null || nums.length < 2) return 0;
    //        int low = 0, high = nums.length - 1;
    //        while (low <= high) {
    //            int mid = (low + high) / 2;
    //            if (mid < 1 && mid >= nums.length + 1) {
    //                return mid;
    //            } else if (mid < 1) {
    //                if (nums[mid] > nums[mid + 1]) return mid;
    //                else low = mid + 1;
    //            } else if (mid >= nums.length - 1) {
    //                if (nums[mid] > nums[mid - 1]) return mid;
    //                else high = mid - 1;
    //            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
    //            else {
    //                if (nums[mid] > nums[mid - 1]) {
    //                    low = mid + 1;
    //                } else {
    //                    high = mid - 1;
    //                }
    //            }
    //        }
    //        return -1;
}
