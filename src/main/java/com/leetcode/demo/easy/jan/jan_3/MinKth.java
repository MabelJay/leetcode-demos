package com.leetcode.demo.easy.jan.jan_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinKth {

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        //  1 2 4 5 6 7 9 10
        int[] arr = {1, 4, 2, 2, 5, 5, 7, 9, 10, 6};

        System.out.println(minKth1(arr, 5));
//        System.out.println(minKth2(arr, 4));
        System.out.println(minKth3(arr, 5));
    }

    public static int minKth1(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.peek();
    }

    public static int minKth2(int[] arr, int k) {
        int len = arr.length - 1;
        int beginIndex = (len - 1) / 2;
        for (int i = beginIndex; i >= 0; i--) {
            buildMinHeap(arr, i, len);
        }
//        System.out.println("initial min heap is:" + Arrays.toString(arr));
        int i = len;
        for (; i > len - k + 1; i--) {
            swap(arr, 0, i);
            buildMinHeap(arr, 0, i - 1);
//            System.out.println(Arrays.toString(arr));
        }
        return arr[0];
    }

    public static void buildMinHeap(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = left + 1;
        if (left > len) return;
        int cMin = left;
        if (right <= len && arr[right] < arr[left]) {
            cMin = right;
        }
        if (arr[cMin] < arr[i]) {
            swap(arr, i, cMin);
            buildMinHeap(arr, cMin, len);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int minKth3(int[] arr, int k) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        return process(newArr, 0, arr.length - 1, k - 1);
    }

    public static int process(int[] arr, int l, int r, int index) {
        if (l == r) {
            return arr[l];
        }
        int pivot = arr[l + (int) (Math.random() * (r - l + 1))];
        int[] partitionRange = partition(arr, l, r, pivot);
        if (index >= partitionRange[0] && index <= partitionRange[1]) {
            return arr[index];
        } else if (index < partitionRange[0]) {
            return process(arr, l, partitionRange[0] - 1, index);
        } else {
            return process(arr, partitionRange[1] + 1, r, index);
        }
    }

    public static int[] partition(int[] arr, int l, int r, int pivot) {
        int small = l - 1;
        int large = r + 1;
        int cur = l;
        while (cur < large) {
            if (arr[cur] < pivot) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivot) {
                swap(arr, --large, cur);
            } else {
                cur++;
            }
        }
        return new int[]{small + 1, large - 1};
    }
}
