package com.leetcode.demo.easy;

import java.util.Arrays;

public class MergeSortedlist {
    public static void main(String[] args) {
        //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // ：[1,2,2,3,5,6]
        int[] num1 = {0}, num2 = {0};
        MergeSortedlist mergeSortedlist = new MergeSortedlist();
        mergeSortedlist.merge5(num1, 0, num2, 0);
        System.out.println(Arrays.toString(num1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        int temp, j;
        for (int i = 0; i < n; i++) {
            j = m + i - 1;
            temp = nums2[i];

            while (j >= 0 && nums1[j] > temp) {
                nums1[j + 1] = nums1[j];
                j--;
            }
            nums1[j + 1] = temp;
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int tmpPos = 0;
        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                arr[tmpPos++] = nums1[p1++];
            } else {
                arr[tmpPos++] = nums2[p2++];
            }
        }
        while (p1 < m) {
            arr[tmpPos++] = nums1[p1++];
        }

        while (p2 < n) {
            arr[tmpPos++] = nums2[p2++];
        }

        for (int i = 0; i < (m + n); i++) {
            nums1[i] = arr[i];
        }
    }

    public void merge4(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int tmpPos = 0;
        int p1 = 0, p2 = 0;

        while (p1 < m || p2 < n) {
            if (p1 >= m) {
                arr[tmpPos++] = nums2[p2++];
            } else if (p2 >= n) {
                arr[tmpPos++] = nums1[p1++];
            } else if (nums1[p1] > nums2[p2]) {
                arr[tmpPos++] = nums2[p2++];
            } else {
                arr[tmpPos++] = nums1[p1++];
            }
        }
        for (int i = 0; i < (m + n); i++) {
            nums1[i] = arr[i];
        }
    }

    public void merge5(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int index = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) nums1[index--] = nums2[p2--];
            else if (p2 < 0) nums1[index--] = nums1[p1--];
            else if (nums1[p1] > nums2[p2]) nums1[index--] = nums1[p1--];
            else nums1[index--] = nums2[p2--];
        }
    }
}
