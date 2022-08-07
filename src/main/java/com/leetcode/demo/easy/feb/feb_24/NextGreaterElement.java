package com.leetcode.demo.easy.feb.feb_24;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;

public class NextGreaterElement {

    public static void main(String[] args) {
        // 101
        // 110

        // 230241
        // 230412
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new NextGreaterElement().nextGreaterElement(230241));
    }

    public int nextGreaterElement(int n) {
        char[] arr = ("" + n).toCharArray();
        int len = arr.length;
        int index1 = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index1 = i;
                break;
            }
        }
        if (index1 == -1) return -1;
        int j = len - 1;
        while (j > index1 && arr[j] <= arr[index1]) {
            j--;
        }
        swap(arr, index1, j);
        reverseArr(arr, index1 + 1, arr.length - 1);
        try {
            return Integer.parseInt(new String(arr));
        }catch (Exception e) {
            return -1;
        }
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverseArr(char[] arr, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
