package com.leetcode.demo.interview;

public class FindKthLargest2 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(new FindKthLargest2().findKthLargest(arr, k));
    }

    public int findKthLargest(int[] nums, int k) {
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
        int cur = left;

        while (cur < large) {
            if (nums[cur] > pivot) {
                swap(nums, ++small, cur++);
            } else if (nums[cur] < pivot) {
                swap(nums, --large, cur);
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
