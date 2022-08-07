package com.leetcode.demo.easy.dec.dec_24;

import java.util.LinkedList;

public class FindSub {

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 3, 2, 5};

        System.out.println(new FindSub().findSeqNum2(arr, 3));
    }

    // O(n*n)
    public int findSeqNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int max = arr[i], min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
//                System.out.println("max=" + max + "min=" + min);
                if (max - min <= num) count++;
            }
        }
        return count + arr.length;
    }

    public int findSeqNum2(int[] arr, int num) {
        if (arr == null || arr.length == 0) return 0;
        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();
        int l = 0, r = 0;
        int res = 0;
        while (l < arr.length) {
            while (r < arr.length) {
                while (!qMin.isEmpty() && arr[r] < arr[qMin.peekLast()]) {
                    qMin.pollLast();
                }
                qMin.addLast(r);

                while (!qMax.isEmpty() && arr[r] >= arr[qMax.peekLast()]) {
                    qMax.pollLast();
                }
                qMax.addLast(r);
                if (arr[qMax.peekFirst()] - arr[qMin.peekFirst()] > num) {
                    break;
                }
                r++;
            }
            res += r - l;

            if (qMin.peekFirst() == l) {
                qMin.pollFirst();
            }
            if (qMax.peekFirst() == l) {
                qMax.pollFirst();
            }
            l++;
        }
        return res;
    }
}
