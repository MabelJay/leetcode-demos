package com.leetcode.demo.easy.mar.mar_03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKth {

    static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 2, 3, 9, 10, 11, 0};
        System.out.println(findKth1(arr, 4));
        System.out.println(findKth2(arr, 4));
        System.out.println(findKth3(arr, 4));
    }

    public static int findKth1(int[] arr, int k) {
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

    public static int findKth2(int[] arr, int k) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        return process(newArr, 0, arr.length - 1, k - 1);
    }

    public static int process(int[] arr, int left, int right, int index) {
        if (left == right) return arr[left];

        int pivot = arr[left + (int) (Math.random() * (right - left + 1))];

        int[] range = partition(arr, pivot, left, right);
        if (index >= range[0] && index <= range[1]) {
            return arr[index];
        } else if (index > range[1]) {
            return process(arr, range[1] + 1, right, index);
        } else return process(arr, left, range[0] - 1, index);
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


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int findKth3(int[] arr, int k) {
        return bfprt(arr, 0, arr.length - 1, k - 1);
    }

    public static int bfprt(int[] arr, int left, int right, int index) {
        if (left == right) return arr[left];

        int pivot = mediaOfMedias(arr, left, right);
        int[] range = partition(arr, pivot, left, right);
        if (index >= range[0] && index <= range[1]) return arr[index];
        else if (index > range[1]) return bfprt(arr, range[1] + 1, right, index);
        return bfprt(arr, left, range[0] - 1, index);
    }

    public static int mediaOfMedias(int[] arr, int left, int right) {
        int nums = right - left + 1;

        int offset = nums % 5 == 0 ? 0 : 1;

        int[] medias = new int[nums / 5 + offset];

        for (int i = 0; i < medias.length; i++) {
            medias[i] = getMedias(arr, left + 5 * i, Math.min(right, left + 5 * i + 4));
        }

        return bfprt(medias, 0, medias.length - 1, medias.length / 2);
    }

    public static int getMedias(int[] arr, int left, int right) {
        for (int j = left + 1; j <= right; j++) {
            int temp = arr[j];
            int i = j - 1;
            while (i >= left && arr[i] > temp) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = temp;
        }
        return arr[(left + right) / 2];
    }
}
