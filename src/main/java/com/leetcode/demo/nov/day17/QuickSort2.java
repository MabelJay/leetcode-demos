package com.leetcode.demo.nov.day17;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 8, 10, 6, 4, 2};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = arr[left + (int) (Math.random() * (right - left + 1))];
        int[] range = partition(arr, pivot, left, right);
        sort(arr, left, range[0] - 1);
        sort(arr, range[1] + 1, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] partition(int[] arr, int pivot, int left, int right) {
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
        return new int[]{small + 1, large - 1};
    }
}
