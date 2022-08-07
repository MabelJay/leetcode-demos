package com.leetcode.demo.easy.jan.jan_29;

import java.util.PriorityQueue;

public class FindKthLargest {

    public static void main(String[] args) {
        // 输入: [3,2,1,5,6,4] 和 k = 2
        //输出: 5

        int[] nums = {7, 6, 5, 4, 3, 2, 1};

        // [7,6,5,4,3,2,1]
        //5
        System.out.println(new FindKthLargest().findKthLargest(nums, 5));
//        System.out.println(new FindKthLargest().findKthLargest2(nums, 4));
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
        return process(nums, k - 1, 0, nums.length - 1);
    }

    public int process(int[] nums, int index, int left, int right) {
        if (left == right) return nums[left];
        int pivot = nums[left + (int) (Math.random() * (right - left + 1))];
        int[] range = partition(nums, pivot, left, right);
        if (index >= range[0] && index <= range[1]) return nums[index];
        else if (index < range[0]) return process(nums, index, left, range[0] - 1);
        else return process(nums, index, range[1] + 1, right);
    }

    public int[] partition(int[] nums, int pivot, int left, int right) {
        int small = left - 1, large = right + 1;
        int cur = left;

        while (cur < large) {
            if (nums[cur] > pivot) {
                swap(nums, ++small, cur++);
            } else if (nums[cur] < pivot) {
                swap(nums, --large, cur);
            } else {
                cur++;
            }
        }
        return new int[]{small + 1, large - 1};
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest3(int[] nums, int k) {
        return bfprt(nums, k - 1, 0, nums.length - 1);
    }

    public int bfprt(int[] nums, int index, int left, int right) {
        if (left == right) return nums[left];
        int pivot = mediaOfMedias(nums, left, right);
        int[] range = partition(nums, pivot, left, right);
        if (index >= range[0] && index <= range[1]) return nums[index];
        else if (index < range[0]) return bfprt(nums, index, left, range[0] - 1);
        else return bfprt(nums, index, range[1] + 1, right);
    }

    public int mediaOfMedias(int[] nums, int left, int right) {
        int numEle = right - left + 1;
        int offset = numEle % 5 == 0 ? 0 : 1;
        int[] medias = new int[numEle / 5 + offset];

        for (int i = 0; i < medias.length; i++) {
            medias[i] = computeMedia(nums, left + i * 5, Math.min(right, left + 5 * i + 4));
        }

        return bfprt(medias, medias.length / 2, 0, medias.length - 1);
    }

    public int computeMedia(int[] nums, int left, int right) {
        int temp, i;
        for (int j = left + 1; j <= right; j++) {
            temp = nums[j];
            i = j - 1;

            while (i >= left && nums[i] > temp) {
                nums[i + 1] = nums[i];
                i--;
            }
            nums[i + 1] = temp;
        }
        return nums[(right + left) / 2];
    }
}
