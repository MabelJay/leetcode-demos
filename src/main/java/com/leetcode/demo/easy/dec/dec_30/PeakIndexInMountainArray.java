package com.leetcode.demo.easy.dec.dec_30;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        // 输入：arr = [0,1,0]
        //输出：1

        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        System.out.println(new PeakIndexInMountainArray().peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length < 3) return -1;
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return -1;
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
