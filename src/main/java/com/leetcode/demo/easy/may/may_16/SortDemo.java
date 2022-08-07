package com.leetcode.demo.easy.may.may_16;

import java.util.Arrays;

public class SortDemo {

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 6, 7, 8, 10, 5, 2};
//        insertionSort(arr);
//        shellSort(arr);
//        bubbleSort(arr);
//        selectionSort(arr);
//        heapSort(arr);
//        mergeSort(arr);
//        quickSort(arr);
        quickSort2(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 0));
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int j = 1; j < arr.length; j++) {
            int i = j - 1;
            int temp = arr[j];

            while (i >= 0 && arr[i] > temp) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = temp;
        }
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int j = step; j < arr.length; j++) {
                int temp = arr[j];
                int i = j - step;

                while (i >= 0 && arr[i] > temp) {
                    arr[i + step] = arr[i];
                    i -= step;
                }
                arr[i + step] = temp;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int len = arr.length - 1;
        int beginIndex = (len - 1) / 2;
        for (int i = beginIndex; i >= 0; i--) {
            buildHeap(arr, i, len);
        }

        for (int i = len; i > 0; i--) {
            swap(arr, 0, i);
            buildHeap(arr, 0, i - 1);
        }
    }

    public static void buildHeap(int[] arr, int index, int len) {
        int left = index * 2 + 1;
        if (left > len) return;
        int right = left + 1;
        int cMax = left;
        if (right <= len && arr[right] > arr[left]) cMax = right;

        if (arr[cMax] > arr[index]) {
            swap(arr, cMax, index);
            buildHeap(arr, cMax, len);
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int[] tmpArr = new int[arr.length];
        sort1(arr, tmpArr, 0, arr.length - 1);
    }

    public static void sort1(int[] arr, int[] tmpArr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort1(arr, tmpArr, left, mid);
            sort1(arr, tmpArr, mid + 1, right);
            merge(arr, tmpArr, left, mid + 1, right);
        }
    }

    public static void merge(int[] arr, int[] tmpArr, int leftPos, int rightPos, int rightEnd) {
        int nums = rightEnd - leftPos + 1;
        int tmpPos = leftPos;
        int leftEnd = rightPos - 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] < arr[rightPos]) {
                tmpArr[tmpPos++] = arr[leftPos++];
            } else tmpArr[tmpPos++] = arr[rightPos++];
        }

        while (leftPos <= leftEnd) {
            tmpArr[tmpPos++] = arr[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArr[tmpPos++] = arr[rightPos++];
        }

        for (int i = 0; i < nums; i++, rightEnd--) {
            arr[rightEnd] = tmpArr[rightEnd];
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        sort2(arr, 0, arr.length - 1);
    }

    public static void sort2(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[left];
            int i = left, j = right;

            while (i < j) {
                while (i < j && arr[j] >= pivot) {
                    j--;
                }
                arr[i] = arr[j];

                while (i < j && arr[i] <= pivot) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = pivot;
            sort2(arr, left, i);
            sort2(arr, i + 1, right);
        }
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) return;
        sort3(arr, 0, arr.length - 1);
    }

    public static void sort3(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = mediaOf3(arr, left, right);
            int i = left, j = right - 1;

            while (i < j) {
                while (arr[++i] < pivot) {
                }

                while (arr[--j] > pivot) {

                }
                if (i < j) swap(arr, i, j);
                else break;
            }
            swap(arr, i, right - 1);
            sort3(arr, left, i - 1);
            sort3(arr, i + 1, right);
        }
    }

    public static int mediaOf3(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[left] > arr[center]) swap(arr, left, center);
        if (arr[left] > arr[right]) swap(arr, left, right);
        if (arr[center] > arr[right]) swap(arr, center, right);

        swap(arr, center, right - 1);
        return arr[right - 1];
    }

    public static int binarySearch(int[] arr, int target) {
        if (arr.length == 0) return -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
