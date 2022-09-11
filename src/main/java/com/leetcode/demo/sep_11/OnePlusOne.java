package com.leetcode.demo.sep_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OnePlusOne {

    public static void main(String[] args) {
        //输入：digits = [1,2,3]
        //输出：[1,2,4]

        // 1,2,9
        // 130

        int[] digits = {1, 2, 3};
        System.out.println(Arrays.toString(new OnePlusOne().plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;

        List<Integer> list = new ArrayList<>();
        int left = 1;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int sum = left + digits[i];
            list.add(sum % 10);
            left = sum / 10;
        }
        if (left != 0) list.add(left);
        int[] resArr = new int[list.size()];
        int index = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            resArr[index++] = list.get(i);
        }
        return resArr;
    }
}
