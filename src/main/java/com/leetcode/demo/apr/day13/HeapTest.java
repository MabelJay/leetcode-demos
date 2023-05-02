package com.leetcode.demo.apr.day13;

import java.util.PriorityQueue;

public class HeapTest {

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 1, 2, 9};
        testHeap(arr);
    }

    public static void testHeap(int[] input) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
            System.out.println(queue.peek());
        }

        System.out.println("-----------");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
