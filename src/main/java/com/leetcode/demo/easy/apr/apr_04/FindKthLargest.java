package com.leetcode.demo.easy.apr.apr_04;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {

    public static void main(String[] args) {
        // 输入: [3,2,1,5,6,4] 和 k = 2
        //输出: 5

        // [7,6,5,4,3,2,1]
        //5

        int[] nums = {3,2,1,5,6,4};
        System.out.println(new FindKthLargest().findKthLargest(nums, 5));
        System.out.println(new FindKthLargest().findKthLargest2(nums, 5));
        System.out.println(new FindKthLargest().findKthLargest3(nums, 5));
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
        return process(nums, 0, nums.length - 1, k - 1);
    }

    public int process(int[] nums, int left, int right, int index) {
        if (left == right) return nums[left];
        int pivot = nums[left + (int) (Math.random() * (right - left + 1))];
        int[] range = partition(nums, pivot, left, right);
        if (index >= range[0] && index <= range[1]) return nums[index];
        else if (index < range[0]) return process(nums, left, range[0] - 1, index);
        else return process(nums, range[1] + 1, right, index);
    }

    public int[] partition(int[] nums, int pivot, int left, int right) {
        int small = left - 1;
        int large = right + 1;
        int cur = right;

        while (cur > small) {
            if (nums[cur] > pivot) {
                swap(nums, ++small, cur);
            } else if (nums[cur] < pivot) {
                swap(nums, --large, cur--);
            } else cur--;
        }

        return new int[]{small + 1, large - 1};
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findKthLargest3(int[] nums, int k) {
        return bfprt(nums, 0, nums.length - 1, k - 1);
    }

    public int bfprt(int[] nums, int left, int right, int index) {
        if (left == right) return nums[left];
        int pivot = mediaOfMedias(nums, left, right);
        int[] range = partition(nums, pivot, left, right);
        if (index >= range[0] && index <= range[1]) return nums[index];
        else if (index < range[0]) return bfprt(nums, left, range[0] - 1, index);
        else return bfprt(nums, range[1] + 1, right, index);
    }

    public int mediaOfMedias(int[] nums, int left, int right) {
        int eleNums = right - left + 1;
        int offset = eleNums % 5 == 0 ? 0 : 1;

        int[] medias = new int[eleNums / 5 + offset];
        for (int i = 0; i < medias.length; i++) {
            medias[i] = computeMedia(nums, 5 * i + left, Math.min(5 * i + 4 + left, right));
        }

        return bfprt(medias, 0, medias.length - 1, medias.length / 2);
    }

    public int computeMedia(int[] arr, int left, int right) {
        for (int j = left + 1; j <= right; j++) {
            int temp = arr[j];
            int i = j - 1;

            while (i >= left && arr[i] < temp) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = temp;
        }

        return arr[(right + left) / 2];
    }
}
