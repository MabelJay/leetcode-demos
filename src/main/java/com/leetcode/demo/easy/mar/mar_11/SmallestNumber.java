package com.leetcode.demo.easy.mar.mar_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestNumber {
    public static void main(String[] args) {
        long num = 310;
        long num2 = -7605;
        long num3 = 95005;
        System.out.println(new SmallestNumber().smallestNumber(num));
        System.out.println(new SmallestNumber().smallestNumber(num2));
        System.out.println(new SmallestNumber().smallestNumber(num3));
    }

    public long smallestNumber(long num) {
        if (num == 0) return num;
        boolean isNegative = false;
        if (num < 0) isNegative = true;

        StringBuilder sb = new StringBuilder("" + Math.abs(num));

        if (sb.length() == 1) return num;

        int len = sb.length();
        int[] arr = new int[len];
        for (int i = 0; i < sb.length(); i++) {
            arr[i] = sb.charAt(i) - '0';
        }
//        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        if (!isNegative) {
            if (arr[0] == 0) {
                int index = 1;
                while (index < len) {
                    if (arr[index] > 0) break;
                    index++;
                }
                swap(arr, 0, index);
            }
        }
        sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(arr[i]);
        }
//        System.out.println(sb);
        if (isNegative) {
            return Long.parseLong(sb.reverse().toString()) * -1;
        } else return Long.parseLong(sb.toString());
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
