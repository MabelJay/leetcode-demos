package com.leetcode.demo.easy.mar.mar_23;

import java.util.Arrays;

public class PrevPermOpt1 {

    public static void main(String[] args) {
        // 输入：arr = [1,9,4,6,7]
        //输出：[1,7,4,6,9]
        //解释：交换 9 和 7
        int[] arr = {1, 9, 4, 6, 7};

        //[3,2,1]
        int[] arr2 = {3, 2, 1};

        // arr = [1,1,5]
        int[] arr3 = {1, 1, 5};

        // [3,1,1,3]
        int[] arr4 = {3, 1, 1, 3};
        System.out.println(Arrays.toString(new PrevPermOpt1().prevPermOpt1(arr)));
        System.out.println(Arrays.toString(new PrevPermOpt1().prevPermOpt1(arr2)));

        System.out.println(Arrays.toString(new PrevPermOpt1().prevPermOpt1(arr3)));
        System.out.println(Arrays.toString(new PrevPermOpt1().prevPermOpt1(arr4)));
    }

    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        int right = len - 1;
        int index1 = -1;
        while (right > 0) {
            if (arr[right - 1] > arr[right]) {
                index1 = right - 1;
                break;
            }
            right--;
        }
        if (index1 == -1) return arr;
        int max = arr[right];
        int index2 = right;
        while (right < len) {
            if (arr[right] > max && arr[right] < arr[index1]) {
                max = arr[right];
                index2 = right;
            }
            right++;
        }
        swap(arr, index1, index2);
        return arr;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
