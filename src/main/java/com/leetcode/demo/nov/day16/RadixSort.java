package com.leetcode.demo.nov.day16;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {63, 157, 189, 51, 101, 47, 141, 121, 157, 156,
                194, 117, 98, 139, 67, 133, 181, 12, 28, 0, 109};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(isSorted(arr));
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int len = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int val : arr) {
            maxVal = Math.max(maxVal, val);
        }

        for (int exp = 1; maxVal / exp > 0; exp *= 10) {
            int[] temp = new int[len];
            int[] buckets = new int[10];

            for (int val : arr) {
                int index = val / exp % 10;
                buckets[index]++;
            }

            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            for (int i = len - 1; i >= 0; i--) {
                int index = arr[i] / exp % 10;
                temp[buckets[index] - 1] = arr[i];
                buckets[index]--;
            }
            System.arraycopy(temp, 0, arr, 0, len);
        }
    }
}
