package com.leetcode.demo.easy.june.june_09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class FindKth {

    static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        int[] arr = getArr(50, 10);
        System.out.println(Arrays.toString(arr));
        System.out.println(findKth1(arr, 5));
        System.out.println(findKth2(arr, 5));
        System.out.println(findKth3(arr, 5));
    }

    public static int[] getArr(int maxVal, int len) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(maxVal);
        }
        return arr;
    }

    public static int findKth1(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new MaxHeapComparator());
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        return queue.poll();
    }

    public static int findKth2(int[] arr, int k) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        return process(newArr, k - 1, 0, newArr.length - 1);
    }

    public static int process(int[] arr, int index, int left, int right) {
        if (left == right) return arr[left];

        int pivot = arr[left + (int) (Math.random() * (right - left + 1))];
        int[] range = partition(arr, left, right, pivot);
        if (index >= range[0] && index <= range[1]) return arr[index];
        else if (index < range[0]) return process(arr, index, left, range[0] - 1);
        else return process(arr, index, range[1] + 1, right);
    }

    public static int[] partition(int[] arr, int left, int right, int pivot) {
        int small = left - 1;
        int large = right + 1;
        int cur = left;

        while (cur < large) {
            if (arr[cur] < pivot) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivot) swap(arr, --large, cur);
            else cur++;
        }
        return new int[]{small + 1, large - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int findKth3(int[] arr, int k) {
        return bfprt(arr, k - 1, 0, arr.length - 1);
    }

    public static int bfprt(int[] arr, int index, int left, int right) {
        if (left == right) return arr[left];
        int pivot = mediaOfMedias(arr, left, right);
        int[] range = partition(arr, left, right, pivot);
        if (index <= range[1] && index >= range[0]) return arr[index];
        else if (index < range[0]) return bfprt(arr, index, left, range[0] - 1);
        else return bfprt(arr, index, range[1] + 1, right);
    }

    public static int mediaOfMedias(int[] arr, int left, int right) {
        int nums = right - left + 1;
        int offset = nums % 5 == 0 ? 0 : 1;
        int[] medias = new int[nums / 5 + offset];
        for (int i = 0; i < medias.length; i++) {
            medias[i] = computeMedia(arr, left + 5 * i, Math.min(right, 5 * i + 4));
        }
        return bfprt(medias, medias.length / 2, 0, medias.length - 1);
    }

    public static int computeMedia(int[] arr, int left, int right) {
        for (int j = left + 1; j <= right; j++) {
            int temp = arr[j];
            int i = j - 1;
            while (i >= left && arr[i] > temp) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = temp;
        }
        return arr[(right + left) / 2];
    }
}
