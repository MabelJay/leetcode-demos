package com.leetcode.demo.dec.day03;

import java.util.Arrays;
import java.util.Random;

public class SortDemos {

    public static void main(String[] args) {
        int[] arr = getArr(7, 20);
        System.out.println(Arrays.toString(arr));
//        insertionSort(arr);
//        shellSort(arr);
//        bubbleSort(arr);
//        selectionSort(arr);
//        heapSort(arr);
//        mergeSort(arr);
//        quickSort1(arr);
//        quickSort2(arr);
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(isSorted(arr));
        System.out.println(binarySearch(arr, 11));
    }

    public static int[] getArr(int len, int maxVal) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(maxVal);
        }
        return arr;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int j = 1; j < arr.length; j++) {
            int temp = arr[j];
            int i = j - 1;
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

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j + 1, j);
                }
            }
        }
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
            swap(arr, i, min);
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int len = arr.length - 1;
        int beginIndex = (len - 1) / 2;
        for (int i = beginIndex; i >= 0; i--) {
            buildHeap(arr, i, len);
        }
        System.out.println("initial heap: " + Arrays.toString(arr));

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
            int mid = (right - left) / 2 + left;
            sort1(arr, tmpArr, left, mid);
            sort1(arr, tmpArr, mid + 1, right);
            merge(arr, tmpArr, left, mid + 1, right);
        }
    }

    public static void merge(int[] arr, int[] tmpArr, int leftPos, int rightPos, int rightEnd) {
        int nums = rightEnd - leftPos + 1;
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;

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

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) return;
        sort2(arr, 0, arr.length - 1);
    }

    public static void sort2(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getMediaOf3(arr, left, right);
            int i = left, j = right - 1;
            while (i < j) {
                while (arr[++i] < pivot) {

                }
                while (arr[--j] > pivot) {

                }
                if (i < j) {
                    swap(arr, i, j);
                } else break;
            }

            swap(arr, i, right - 1);
            sort2(arr, left, i - 1);
            sort2(arr, i + 1, right);
        }
    }

    public static int getMediaOf3(int[] arr, int left, int right) {
        int mid = (right - left) / 2 + left;
        if (arr[left] > arr[mid]) swap(arr, left, mid);
        if (arr[mid] > arr[right]) swap(arr, mid, right);
        if (arr[left] > arr[mid]) swap(arr, left, mid);

        swap(arr, mid, right - 1);
        return arr[right - 1];
    }

    private static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) return;
        sort3(arr, 0, arr.length - 1);
    }

    public static void sort3(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = left + (int) (Math.random() * (right - left + 1));
            int[] range = partition(arr, arr[pivot], left, right);
            sort3(arr, left, range[0] - 1);
            sort3(arr, range[1] + 1, right);
        }
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

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int len = arr.length;
        int maxVal = Arrays.stream(arr).max().getAsInt();
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

    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return -1;
    }
}
