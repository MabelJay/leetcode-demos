package com.leetcode.demo.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {

    private static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(new FindKthLargest().findKthLargest2(arr, k));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MyComparator());
        for (int num : nums) {
            priorityQueue.add(num);
//            System.out.println(priorityQueue.peek());
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        return process(nums, k - 1, 0, nums.length - 1);
    }

    public int process(int[] nums, int index, int left, int right) {
        if (left == right) return nums[left];
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int[] range = partition(nums, nums[pivotIndex], left, right);
        if (index >= range[0] && index <= range[1]) return nums[index];
        else if (index < range[0]) {
            return process(nums, index, left, range[0] - 1);
        } else {
            return process(nums, index, range[1] + 1, right);
        }
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
}
