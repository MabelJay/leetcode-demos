package com.leetcode.demo.apr.day17;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findK(arr, k));
        System.out.println(findK2(arr, k));
    }

    private static int findK(int[] arr, int k) {
        if (arr == null || arr.length == 0) return -1;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int j : arr) {
            queue.offer(j);
            if (queue.size() > k) queue.poll();
        }
        return queue.peek();
    }

    private static int findK2(int[] arr, int k) {
        if (arr == null || arr.length == 0) return -1;
        return process(arr, k - 1, 0, arr.length - 1);
    }

    private static int process(int[] arr, int index, int left, int right) {
        if (left == right) return arr[left];
        int pivot = arr[left + (int) (Math.random() * (right - left + 1))];
        int[] range = partition(arr, left, right, pivot);
        System.out.println("range=" + Arrays.toString(range) + "  pivot=" + pivot);
        if (index >= range[0] && index <= range[1]) return arr[index];
        else if (index < range[0]) return process(arr, index, left, range[0] - 1);
        else return process(arr, index, range[1] + 1, right);
    }

    private static int[] partition(int[] arr, int left, int right, int pivot) {
        int small = left - 1;
        int large = right + 1;
        int cur = left;

        while (cur < large) {
            if (arr[cur] > pivot) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] < pivot) {
                swap(arr, --large, cur);
            } else cur++;
        }
        return new int[]{small + 1, large - 1};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
