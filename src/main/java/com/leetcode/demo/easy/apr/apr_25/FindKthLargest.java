package com.leetcode.demo.easy.apr.apr_25;

import java.util.PriorityQueue;

public class FindKthLargest {

    public static void main(String[] args) {
        // 输入: [3,2,1,5,6,4] 和 k = 2
        //输出: 5

        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(new FindKthLargest().findKthLargest(arr, 2));
        System.out.println(new FindKthLargest().findKthLargest3(arr, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        return process(nums, k - 1, 0, nums.length - 1);
    }

    public int process(int[] arr, int index, int left, int right) {
        if (left == right) return arr[left];
        int pivot = arr[left + (int) (Math.random() * (right - left + 1))];
        int[] range = partition(arr, pivot, left, right);
        if (index >= range[0] && index <= range[1]) return arr[index];
        else if (index < range[0]) return process(arr, index, left, range[0] - 1);
        else return process(arr, index, range[1] + 1, right);
    }

    public int[] partition(int[] arr, int pivot, int left, int right) {
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

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findKthLargest3(int[] nums, int k) {
        return bfprt(nums, k - 1, 0, nums.length - 1);
    }

    public int bfprt(int[] arr, int index, int left, int right) {
        if (left == right) return arr[left];
        int pivot = mediaOfMedias(arr, left, right);
        int[] range = partition(arr, pivot, left, right);
        if (index >= range[0] && index <= range[1]) return arr[index];
        else if (index < range[0]) return bfprt(arr, index, left, range[0] - 1);
        else return bfprt(arr, index, range[1] + 1, right);
    }

    public int mediaOfMedias(int[] arr, int left, int right) {
        int nums = right - left + 1;
        int offset = nums % 5 == 0 ? 0 : 1;
        int[] medias = new int[nums / 5 + offset];

        for (int i = 0; i < medias.length; i++) {
            medias[i] = computeMedia(arr, left + 5 * i, Math.min(right, left + 5 * i + 4));
        }

        return bfprt(medias, medias.length / 2, 0, medias.length - 1);
    }

    public int computeMedia(int[] arr, int left, int right) {
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

