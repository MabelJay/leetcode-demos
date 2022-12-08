package com.leetcode.demo.dec.day03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestK {

    private static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        // 输入： arr = [1,3,5,7,2,4,6,8], k = 4
        //输出： [1,2,3,4]

        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        System.out.println(Arrays.toString(new SmallestK().smallestK2(arr, 4)));
    }

    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) return new int[0];

        int[] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new MaxHeapComparator());

        for (int j : arr) {
            queue.add(j);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;
    }

    public int[] smallestK2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) return new int[0];
        getKthNum(arr, k, 0, arr.length - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void getKthNum(int[] arr, int k, int left, int right) {
        if (left >= right) return;
        int pivot = arr[left + (int) (Math.random() * (right - left + 1))];
        int[] range = partition(arr, pivot, left, right);
        if (k >= range[0] && k <= range[1]) return;
        else if (k < range[0]) {
            getKthNum(arr, k, left, range[0] - 1);
        } else getKthNum(arr, k, range[1] + 1, right);
    }

    public int[] partition(int[] arr, int pivot, int left, int right) {
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

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
