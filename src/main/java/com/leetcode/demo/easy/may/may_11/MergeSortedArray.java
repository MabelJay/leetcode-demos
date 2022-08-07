package com.leetcode.demo.easy.may.may_11;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 7, 9};
        int[] arr2 = {5, 6, 9, 10, 11, 13};

        int[] res = new MergeSortedArray().mergeSortedArray(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }

    public int[] mergeSortedArray(int[] arr1, int[] arr2) {
        int index = 0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] resArr = new int[len1 + len2];

        int indexOfArr1 = 0;
        int indexOfArr2 = 0;

        while (indexOfArr1 < len1 && indexOfArr2 < len2) {
            if (arr1[indexOfArr1] < arr2[indexOfArr2]) {
                resArr[index++] = arr1[indexOfArr1++];
            } else resArr[index++] = arr2[indexOfArr2++];
        }

        while (indexOfArr1 < len1) {
            resArr[index++] = arr1[indexOfArr1++];
        }

        while (indexOfArr2 < len2) {
            resArr[index++] = arr2[indexOfArr2++];
        }
        return resArr;
    }
}
