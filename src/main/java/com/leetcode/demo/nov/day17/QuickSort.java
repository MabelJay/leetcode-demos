package com.leetcode.demo.nov.day17;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 9, 2, 10, 10, 7, 8};
//        System.out.println(Math.random() * (arr.length));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        sort1(arr, 0, arr.length - 1);
    }

    private static void sort1(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[left + (int) (Math.random() * (right - left + 1))];
            int[] range = partition(arr, pivot, left, right);
            sort1(arr, left, range[0] - 1);
            sort1(arr, range[1] + 1, right);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int[] partition(int[] arr, int pivot, int left, int right) {
        int small = left - 1;
        int large = right + 1;
        int cur = left;

        while (cur < large) {
            if (arr[cur] < pivot) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivot) {
                swap(arr, --large, cur);
            } else cur++;
        }
        return new int[]{small + 1, right - 1};
    }
}
