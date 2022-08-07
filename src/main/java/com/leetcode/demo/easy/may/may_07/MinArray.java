package com.leetcode.demo.easy.may.may_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinArray {

    public static void main(String[] args) {
        // 输入：numbers = [3,4,5,1,2]
        //输出：1

        int[] arr = {3,4,5,1,2};
        int[] arr2 = {2, 0, 1, 2, 2};

        // 2, 0, 1, 2, 2
        List<int[]> list = new MinArray().getAllReverseArr(arr2);

        for (int[] arrTmp : list) {
            System.out.println(Arrays.toString(arrTmp));
            System.out.println(new MinArray().minArray(arrTmp));
        }
        System.out.println(new MinArray().minArray(arr2));
    }

    public int minArray(int[] numbers) {
        int len = numbers.length;
        int low = 0, high = len - 1;

        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            min = Math.min(numbers[mid], min);
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }
        return min;
    }


    public List<int[]> getAllReverseArr(int[] arr) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int[] tmpArr = new int[arr.length];
            int index = 0;
            int j = i;
            for (; j < arr.length; j++) {
                tmpArr[index++] = arr[j];
            }
            for (int k = 0; k < i; k++) {
                tmpArr[index++] = arr[k];
            }
            list.add(tmpArr);
        }
        return list;
    }
}
