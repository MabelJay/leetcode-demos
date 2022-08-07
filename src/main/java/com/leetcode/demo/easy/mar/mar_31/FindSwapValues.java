package com.leetcode.demo.easy.mar.mar_31;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSwapValues {

    public static void main(String[] args) {
        // 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
        //输出: [1, 3]
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        // [855, 110, 365, 337, 237, 203, 80, 895, 346, 628]
        //[87, 64, 91, 21, 18, 98, 87, 52]
        int[] array3 = {855, 110, 365, 337, 237, 203, 80, 895, 346, 628};
        int[] array4 = {87, 64, 91, 21, 18, 98, 87, 52};
        System.out.println(Arrays.toString(new FindSwapValues().findSwapValues(array3, array4)));
    }

    public int[] findSwapValues(int[] array1, int[] array2) {
        Set<Integer> set2 = new HashSet<>();

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < array1.length; i++) {
            sum1 += array1[i];
        }

        for (int i = 0; i < array2.length; i++) {
            set2.add(array2[i]);
            sum2 += array2[i];
        }
        if ((sum1 - sum2) % 2 != 0) return new int[0];
        int diff = (sum1 - sum2) / 2;
        for (int num : array1) {
            if (set2.contains(num - diff)) {
                return new int[]{num, num - diff};
            }
        }
        return new int[0];
    }
}
