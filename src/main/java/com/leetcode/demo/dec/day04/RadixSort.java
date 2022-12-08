package com.leetcode.demo.dec.day04;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {11, 45, 88, 20, 33, 18, 99, 100, 30};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int len = arr.length;
        int maxVal = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; maxVal / exp > 0; exp *= 10) {
            int[] buckets = new int[10];
            int[] tmpArr = new int[len];

            for (int val : arr) {
                int index = val / exp % 10;
                buckets[index]++;
            }

            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            for (int i = len - 1; i >= 0; i--) {
                int index = arr[i] / exp % 10;
                tmpArr[buckets[index] - 1] = arr[i];
                buckets[index]--;
            }
            System.arraycopy(tmpArr, 0, arr, 0, len);
        }
    }
}
