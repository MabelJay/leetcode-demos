package com.leetcode.demo.easy.may.may_12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {

    static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        // 输入：arr = [3,2,1], k = 2
        //输出：[1,2] 或者 [2,1]

        // 示例 2：
        //
        //输入：arr = [0,1,2,1], k = 1
        //输出：[0]

        int[] arr = {3, 2, 1};
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers(arr, 2)));
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers2(arr, 2)));
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers3(arr, 2)));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        int[] res = new int[k];

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

        int index = 0;
        while (!maxHeap.isEmpty()) {
            res[index++] = maxHeap.poll();
        }
        return res;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        int[] res = new int[k];
        int pivot = process(tmpArr, k - 1, 0, tmpArr.length - 1);
        int index = 0;
        for (int i = 0; i < tmpArr.length && index < k; i++) {
            if (tmpArr[i] <= pivot) {
                res[index++] = tmpArr[i];
            }
        }
        return res;
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

    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0) return new int[0];
        int[] res = new int[k];
        int pivot = bfprt(arr, k - 1, 0, arr.length - 1);
        int index = 0;
        for (int i = 0; i < arr.length && index < k; i++) {
            if (arr[i] <= pivot) {
                res[index++] = arr[i];
            }
        }
        return res;
    }

    public int bfprt(int[] arr, int index, int left, int right) {
        if (left == right) return arr[left];
        int pivot = mediaOfMedias(arr, left, right);
        int[] range = partition(arr, pivot, left, right);
        if (index >= range[0] && index <= range[1]) return arr[index];
        else if (index > range[1]) return bfprt(arr, index, range[1] + 1, right);
        else return bfprt(arr, index, left, range[0] - 1);
    }

    public int mediaOfMedias(int[] arr, int left, int right) {
        int nums = right - left + 1;
        int offset = nums % 5 == 0 ? 0 : 1;

        int[] medias = new int[nums / 5 + offset];
        for (int i = 0; i < medias.length; i++) {
            medias[i] = computeMedia(arr, left + 5 * i, Math.min(left + 5 * i + 4, right));
        }
        return bfprt(medias, medias.length / 2, 0, medias.length - 1);
    }

    public int computeMedia(int[] arr, int left, int right) {
        for (int j = left + 1; j <= right; j++) {
            int temp = arr[j];
            int i = j - 1;
            while (i >= left && arr[left] > temp) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = temp;
        }
        return arr[(right + left) / 2];
    }
}
