package com.leetcode.demo.easy;

import java.util.Arrays;

public class ArrayPlusOne {

    public static void main(String[] args) {
        int[] arr = {9, 9};
        System.out.println(Arrays.toString(new ArrayPlusOne().plusOne(arr)));
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1) return digits;

        int len = digits.length - 1;
        int value;
        int carry = (digits[len] + 1) / 10;
        digits[len] = (digits[len] + 1) % 10;

        for (int i = (len - 1); i >= 0; i--) {
            value = digits[i] + carry;
            digits[i] = value % 10;
            carry = value / 10;
            if (carry == 0) {
                break;
            }
        }
        if (carry > 0) {
            digits = Arrays.copyOf(digits, len + 2);
            digits[0] = carry;
        }
        return digits;
    }
}
