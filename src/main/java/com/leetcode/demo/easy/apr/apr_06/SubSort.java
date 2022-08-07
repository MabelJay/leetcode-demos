package com.leetcode.demo.easy.apr.apr_06;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class SubSort {

    public static void main(String[] args) throws InterruptedException {
        // 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
        //输出： [3,9]
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};

        // {1,2,3,4,5,6}
        int[] arr2 = {1, 2, 3, 4, 5, 6};

        // [1,3,9,7,5]
        // [2,4]
        int[] arr3 = {1, 3, 9, 7, 5};

        // [5,3,1,7,9]

        System.out.println(Arrays.toString(new SubSort().subSort(arr)));
        System.out.println(Arrays.toString(new SubSort().subSort2(arr2)));
        System.out.println(Arrays.toString(new SubSort().subSort2(arr3)));

//        TimeUnit.SECONDS.sleep(5);
    }

    public int[] subSort(int[] array) {
        int len = array.length;
        int[] maxArr = new int[len];
        int[] minArr = new int[len];
        int maxVal = Integer.MIN_VALUE;
        int leftIndex = -1;
        int rightIndex = -1;
        for (int i = 0; i < len; i++) {
            maxVal = Math.max(array[i], maxVal);
            maxArr[i] = maxVal;
        }
        System.out.println(Arrays.toString(maxArr));

        for (int i = len - 1; i >= 0; i--) {
            maxVal = Math.min(maxVal, array[i]);
            minArr[i] = maxVal;
        }
        System.out.println(Arrays.toString(minArr));
        for (int i = 0; i < len; i++) {
            if (maxArr[i] > minArr[i]) {
                leftIndex = leftIndex == -1 ? i : Math.min(leftIndex, i);
                rightIndex = rightIndex == -1 ? i : Math.max(rightIndex, i);
            }

        }
        return new int[]{leftIndex, rightIndex};
    }

    public int[] subSort2(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int l = -1;
        int r = -1;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] >= max) max = array[i];
            else r = i;

            if (array[len - i - 1] <= min) min = array[len - i - 1];
            else l = len - i - 1;
        }
        if (l >= r) {
            return new int[]{l, r};
        }
        return new int[]{l, r};
    }
}
