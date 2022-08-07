package com.leetcode.demo.easy.may.may_25_1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class TopN {
    public static void main(String[] args) {
        Iterator<Integer> iterator = Arrays.asList(19, 4, 2, 1, 50, 11, 88, 23, 5, 8, 10, 77, 0).iterator();
        System.out.println(Arrays.toString(new TopN().topN(iterator, 5)));
    }
    public int[] topN(Iterator<Integer> input, int n) {
        int[] buffer = new int[n * 2];
        int index = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while (input.hasNext()) {
            buffer[index++] = input.next();
            if (index == n * 2) {
                index = 0;
                getNth(buffer, n, minHeap);
                buffer = new int[n * 2];
            }
        }
        if (index > 0) {
            getNth(buffer, n, minHeap);
        }
        int[] resArr = new int[n];
        index = 0;
        while (!minHeap.isEmpty()) {
            resArr[index++] = minHeap.poll();
        }
        return resArr;
    }
    public void getNth(int[] arr, int n, PriorityQueue<Integer> minHeap) {
        for (int j : arr) {
            if (minHeap.isEmpty()) minHeap.add(j);
            else if (minHeap.size() < n) {
                minHeap.add(j);
            } else if (minHeap.peek() < j) {
                minHeap.poll();
                minHeap.add(j);
            }
            if (minHeap.size() > n) minHeap.poll();
        }
    }
}
