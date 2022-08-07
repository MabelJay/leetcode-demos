package com.leetcode.demo.easy.apr.apr_07;

import java.util.Arrays;
import java.util.LinkedList;

public class FindLengthOfShortestSubarray {

    public static void main(String[] args) {
        // 输入：arr = [1,2,3,10,4,2,3,5]
        //输出：3
        int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {1};
        System.out.println(new FindLengthOfShortestSubarray().findLengthOfShortestSubarray3(arr));
        System.out.println(new FindLengthOfShortestSubarray().findLengthOfShortestSubarray3(arr2));
        System.out.println(new FindLengthOfShortestSubarray().findLengthOfShortestSubarray3(arr3));
        System.out.println(new FindLengthOfShortestSubarray().findLengthOfShortestSubarray3(arr4));

        // [1,2,3,10,0,7,8,9]
        int[] arr5 = {1, 2, 3, 10, 0, 7, 8, 9};
        // 2
        // [2,2,2,1,1,1]
        int[] arr6 = {2, 2, 2, 1, 1, 1};

        // [1,3,2,4]
        int[] arr7 = {1, 3, 2, 4};
        System.out.println(new FindLengthOfShortestSubarray().findLengthOfShortestSubarray3(arr6));
        System.out.println(new FindLengthOfShortestSubarray().findLengthOfShortestSubarray3(arr5));
        System.out.println(new FindLengthOfShortestSubarray().findLengthOfShortestSubarray3(arr7));

        // [6,3,10,11,15,20,13,3,18,12]
        int[] arr8 = {6, 3, 10, 11, 15, 20, 13, 3, 18, 12};
        System.out.println(new FindLengthOfShortestSubarray().findLengthOfShortestSubarray3(arr8));

        // [16,10,0,3,22,1,14,7,1,12,15]
        // 8
        int[] arr9 = {16, 10, 0, 3, 22, 1, 14, 7, 1, 12, 15};
        System.out.println(new FindLengthOfShortestSubarray().findLengthOfShortestSubarray3(arr9));

        // [22,37,59,16,42,32,29,53,9,55,29,3,4,1,49,17,37,31,27,45,33,24,54,51,32,51,54,31,36,53]
        // 26
        int[] arr10 = {22, 37, 59, 16, 42, 32, 29, 53, 9, 55, 29, 3, 4, 1, 49, 17, 37, 31, 27, 45, 33, 24, 54, 51, 32, 51, 54, 31, 36, 53};
//        System.out.println(arr10.length);
        System.out.println(new FindLengthOfShortestSubarray().findLengthOfShortestSubarray3(arr10));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int index = 1;
        int len = arr.length;
        int leftIndex = -1;
        int rightIndex = -1;
        while (index < len) {
            while (index < len && arr[index - 1] <= arr[index]) {
                index++;
            }
            while (index < len && arr[index - 1] > arr[index]) {
                leftIndex = leftIndex == -1 ? index - 1 : leftIndex;
                rightIndex = index;
                index++;
            }
        }
        if (leftIndex == -1) return 0;
        if (arr[leftIndex] < arr[rightIndex]) return rightIndex - leftIndex - 1;

        int maxLen = Math.max(leftIndex + 1, len - rightIndex);
        int rIndex = rightIndex + 1;
        int lIndex = leftIndex - 1;
        while (rIndex < len && lIndex >= 0) {
            if (arr[rIndex] < arr[lIndex]) rIndex++;
            else break;
        }
        int combineLen1 = lIndex + 1 + len - rIndex;
        if (lIndex >= 0 && rIndex < len && (arr[leftIndex] <= arr[rIndex] || arr[rightIndex] >= arr[lIndex]))
            combineLen1++;
        rIndex = rightIndex + 1;
        lIndex = leftIndex - 1;
        while (lIndex >= 0 && rIndex < len) {
            if (arr[lIndex] > arr[rIndex]) lIndex--;
            else break;
        }
        int combineLen2 = lIndex + 1 + len - rIndex;
        if (lIndex >= 0 && rIndex < len && (arr[leftIndex] <= arr[rIndex] || arr[rightIndex] >= arr[lIndex]))
            combineLen2++;
        return len - Math.max(maxLen, Math.max(combineLen1, combineLen2));
    }

    public int findLengthOfShortestSubarray2(int[] arr) {
        int index = 1;
        int len = arr.length;
        int left = -1;
        int right = -1;
        while (index < len) {
            while (index < len && arr[index - 1] <= arr[index]) {
                index++;
            }
            while (index < len && arr[index - 1] > arr[index]) {
                left = left == -1 ? index - 1 : left;
                right = index;
                index++;
            }
        }
        if (left == -1) return 0;
        if (arr[left] < arr[right]) return right - left - 1;
        int maxLen = Math.max(left + 1, len - right);
        int i = 0, j = right;
        int count = 0;
        while (i <= left && j < len) {
            if (arr[i] <= arr[j]) {
                count = Math.max(count, len - j + i + 1);
                i++;
            } else {
                j++;
            }
        }
        return len - Math.max(maxLen, count);
    }

    public int findLengthOfShortestSubarray3(int[] arr) {
        int len = arr.length;
        int left = 0;
        while (left < len - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == len - 1) return 0;
        int right = len - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        int maxLen = Math.min(len - left - 1, right);
        int i = 0, j = right;
        while (i <= left && j < len) {
            if (arr[i] <= arr[j]) {
                maxLen = Math.min(maxLen, j - i - 1);
                i++;
            } else j++;
        }
        return maxLen;
    }
}
