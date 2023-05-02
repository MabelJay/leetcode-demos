package com.leetcode.demo.apr.day17;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestK {

    public static void main(String[] args) {
        // 输入： arr = [1,3,5,7,2,4,6,8], k = 4
        //输出： [1,2,3,4]

        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;

        int[] arr2 = {1, 2, 3};

        int[] arr3 = {62577, -220, -8737, -22, -6, 59956, 5363, -16699, 0, -10603, 64, -24528, -4818, 96, 5747, 2638, -223,
                37663, -390, 35778, -4977, -3834, -56074, 7, -76, 601, -1712, -48874, 31, 3, -9417, -33152, 775, 9396, 60947,
                -1919, 683, -37092, -524, -8, 1458, 80, -8, 1, 7, -355, 9, 397, -30, -21019, -565, 8762, -4, 531, -211, -23702,
                3, 3399, -67, 64542, 39546, 52500, -6263, 4, -16, -1, 861, 5134, 8, 63701, 40202, 43349, -4283, -3, -22721, -6,
                42754, -726, 118, 51, 539, 790, -9972, 41752, 0, 31, -23957, -714, -446, 4, -61087, 84, -140, 6, 53, -48496, 9,
                -15357, 402, 5541, 4, 53936, 6, 3, 37591, 7, 30, -7197, -26607, 202, 140, -4, -7410, 2031, -715, 4, -60981, 365,
                -23620, -41, 4, -2482, -59, 5, -911, 52, 50068, 38, 61, 664, 0, -868, 8681, -8, 8, 29, 412};
        System.out.println(arr3.length);
//        System.out.println(Arrays.toString(new SmallestK().smallestK(arr, k)));
//        System.out.println(Arrays.toString(new SmallestK().smallestK(arr2, 0)));
        System.out.println(Arrays.toString(new SmallestK().smallestK2(arr3, 131)));
    }

    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1) return new int[0];

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int j : arr) {
            queue.add(j);
            if (queue.size() > k) queue.poll();
        }

        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;
    }

    public int[] smallestK2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1) return new int[0];
        process(arr, k, 0, arr.length - 1);
        int[] res = new int[k];
        int index = 0;

        for (int i = 0; i < k; i++) {
            res[index++] = arr[i];
        }
        return res;
    }

    private void process(int[] arr, int index, int left, int right) {
        if (left == right) return;

        int pivot = arr[left + (int) (Math.random() * (right - left + 1))];
        int[] range = range(arr, left, right, pivot);
        if (index >= range[0] && index <= range[1]) return;
        else if (index < range[0]) process(arr, index, left, range[0] - 1);
        else process(arr, index, range[1] + 1, right);
    }

    private int[] range(int[] arr, int left, int right, int pivot) {
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

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
