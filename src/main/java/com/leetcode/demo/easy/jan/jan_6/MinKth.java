package com.leetcode.demo.easy.jan.jan_6;

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
        // get min k value
        int[] arr = {1, 4, 2, 2, 5, 5, 7, 9, 10, 6};
        System.out.println(minKth1(arr, 7));
        System.out.println(minKth2(arr, 7));
//        System.out.println(Arrays.toString(arr));
        System.out.println(bfprt(arr, 0, arr.length - 1, 6));
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
        int[] newArr = Arrays.copyOf(arr, arr.length);
        return process(newArr, 0, arr.length - 1, k - 1);
    }

    public static int process(int[] arr, int left, int right, int index) {
        if (left == right) {
            return arr[left];
        }
        int pivot = arr[left + (int) (Math.random() * (right - left + 1))];
        int[] partitionRange = partition(arr, left, right, pivot);
//        System.out.println("partition range is: " + Arrays.toString(partitionRange));
        if (index >= partitionRange[0] && index <= partitionRange[1]) {
            return arr[index];
        } else if (index < partitionRange[0]) {
            return process(arr, left, partitionRange[0] - 1, index);
        } else {
            return process(arr, partitionRange[1] + 1, right, index);
        }
    }

    public static int[] partition(int[] arr, int l, int r, int pivot) {
        int small = l - 1, large = r + 1;
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

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int bfprt(int[] arr, int l, int r, int index) {
        if (l == r) {
            return arr[l];
        }
        int pivot = mediaOfMedias(arr, l, r);
        int[] partitionRange = partition(arr, l, r, pivot);
        if (index <= partitionRange[1] && index >= partitionRange[0]) {
            return arr[index];
        } else if (index < partitionRange[0]) {
            return bfprt(arr, l, partitionRange[0] - 1, index);
        } else {
            return bfprt(arr, partitionRange[1] + 1, r, index);
        }
    }

    public static int mediaOfMedias(int[] arr, int l, int r) {
        int num = r - l + 1;
        int extra = num % 5 == 0 ? 0 : 1;
        int[] medias = new int[num / 5 + extra];
        for (int i = 0; i < medias.length; i++) {
            medias[i] = computeMedia(arr, l + i * 5, Math.min(l + i * 5 + 4, r));
        }
        return bfprt(medias, 0, medias.length - 1, medias.length / 2);
    }

    public static int computeMedia(int[] arr, int l, int r) {
        for (int j = l + 1; j <= r; j++) {
            int temp = arr[j];
            int i = j - 1;

            while (i >= l && arr[i] > temp) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = temp;
        }
        return arr[(l + r) / 2];
    }
}
