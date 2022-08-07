package com.leetcode.demo.easy.mar.mar_14;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestKOfArr {

    public static void main(String[] args) {
        // 输入： arr = [1,3,5,7,2,4,6,8], k = 4
        //输出： [1,2,3,4]

        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};

        int[] arr2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new SmallestKOfArr().smallestK(arr2, 0)));
        System.out.println(Arrays.toString(new SmallestKOfArr().smallestK2(arr, 4)));
    }

    public int[] smallestK(int[] arr, int k) {
        if (k == 0) return new int[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

        int[] newArr = new int[k];
        int index = k - 1;
        while (!maxHeap.isEmpty()) {
            newArr[index--] = maxHeap.poll();
        }
        return newArr;
    }

    public int[] smallestK2(int[] arr, int k) {
        if (k == 0) return new int[0];
        int[] resArr = new int[k];
        int index = 0;
        int targetVal = process(arr, k - 1, 0, arr.length-1);
        for (int i = 0; i < arr.length && index < k; i++) {
            if (arr[i] <= targetVal) {
                resArr[index++] = arr[i];
            }
        }
        return resArr;
    }

    public int process(int[] arr, int index, int left, int right) {
        if (left == right) return arr[left];
        int pivot = arr[left + (int) (Math.random() * (right - left + 1))];
        int[] range = partition(arr, left, right, pivot);
        if (index >= range[0] && index <= range[1]) return arr[index];
        else if (index > range[1]) return process(arr, index, range[1] + 1, right);
        else return process(arr, index, left, range[0] - 1);
    }

    public int[] partition(int[] arr, int left, int right, int pivot) {
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
