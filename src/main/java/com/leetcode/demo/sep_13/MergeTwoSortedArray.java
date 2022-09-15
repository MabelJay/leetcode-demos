package com.leetcode.demo.sep_13;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        // 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        //输出：[1,2,2,3,5,6]

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new MergeTwoSortedArray().merge(nums1, 3, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;

        int index1 = 0, index2 = 0;
        while (index1 < m + index2 && index2 < n) {
            if (nums1[index1] > nums2[index2]) {
                // move to next position
                int i = m + n - 2;
                while (i >= index1) {
                    nums1[i + 1] = nums1[i];
                    i--;
                }
                nums1[index1] = nums2[index2];
                index2++;
            }
            index1++;
        }
        while (index2 < n) {
            nums1[index1++] = nums2[index2++];
        }
    }
}
