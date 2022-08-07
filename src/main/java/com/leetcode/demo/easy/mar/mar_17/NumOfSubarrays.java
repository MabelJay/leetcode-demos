package com.leetcode.demo.easy.mar.mar_17;

public class NumOfSubarrays {
    public static void main(String[] args) {
        // 输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
        //输出：3

        int[] arr = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(new NumOfSubarrays().numOfSubarrays(arr, 7, 7));
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        int count = 0;
        int leftEdge = 0, rightEdge = k;
        int sum = 0;
        for (int i = leftEdge; i < rightEdge; i++) {
            sum += arr[i];
        }
        while (rightEdge < len + 1) {
            if (sum / k >= threshold) count++;
            if (rightEdge == len) return count;
            sum -= arr[leftEdge];
            sum += arr[rightEdge];
            leftEdge++;
            rightEdge++;
        }
        return count;
    }

    public int computeAverage(int... num) {
        int sum = 0;
        int len = num.length;
        for (int val : num) {
            sum += val;
        }
        return sum / len;
    }
}
