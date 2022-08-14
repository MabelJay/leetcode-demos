package com.leetcode.demo.aug_14;

import java.util.Arrays;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        // 输入：nums1 = [1,2], nums2 = [3,4]
        //输出：2.50000

        int[] nums1 = {2, 3};
        int[] nums2 = {};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = mergeArr(nums1, nums2);
        System.out.println(Arrays.toString(arr));
        int len = arr.length;
        if (len % 2 == 0) {
            return (double) (arr[len / 2] + arr[len / 2 - 1]) / 2;
        }
        return arr[arr.length / 2];
    }

    public int[] mergeArr(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int[] tmpArr = new int[len];
        int tmpIndex = 0;
        int index1 = 0, index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                tmpArr[tmpIndex++] = arr1[index1++];
            } else {
                tmpArr[tmpIndex++] = arr2[index2++];
            }
        }
        while (index1 < arr1.length) {
            tmpArr[tmpIndex++] = arr1[index1++];
        }
        while (index2 < arr2.length) {
            tmpArr[tmpIndex++] = arr2[index2++];
        }
        return tmpArr;
    }
}
