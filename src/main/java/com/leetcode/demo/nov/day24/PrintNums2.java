package com.leetcode.demo.nov.day24;

import java.util.Arrays;

public class PrintNums2 {

    int count = 0;

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new PrintNums2().printNumbers(3)));
        System.out.println((char) (1 + '0'));
    }

    public int[] printNumbers(int n) {
        if (n <= 0) return new int[0];

        int[] resArr = new int[(int) (Math.pow(10, n) - 1)];
        char[] nums = new char[n];
        Arrays.fill(nums, '0');

        for (int i = 0; i < 10; i++) {
            nums[0] = (char) (i + '0');
            get1ToMaxRecursive(nums, n, 0, resArr);
        }
        return resArr;
    }

    public void get1ToMaxRecursive(char[] nums, int len, int index, int[] arr) {
        if (index == len - 1) {
            // add to arr
            addToArr(nums, arr);
            return;
        }

        for (int i = 0; i < 10; i++) {
            nums[index + 1] = (char) (i + '0');
            get1ToMaxRecursive(nums, len, index + 1, arr);
        }
    }

    public void addToArr(char[] nums, int[] arr) {
        boolean isBeginning = true;
        StringBuilder sb = new StringBuilder();
        for (char num : nums) {
            if (isBeginning && num != '0') isBeginning = false;
            if (!isBeginning) {
                sb.append(num);
            }
        }
        if (!isBeginning) arr[count++] = Integer.parseInt(sb.toString());
    }
}
