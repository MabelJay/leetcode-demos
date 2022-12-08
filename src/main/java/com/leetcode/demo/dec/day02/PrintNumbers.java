package com.leetcode.demo.dec.day02;

import java.util.Arrays;

public class PrintNumbers {

    int count = 0;
    int[] resArr;

    public static void main(String[] args) {
        // 输入: n = 1
        //输出: [1,2,3,4,5,6,7,8,9]
        System.out.println(Arrays.toString(new PrintNumbers().printNumbers(3)));
    }

    public int[] printNumbers(int n) {
        if (n <= 0) return new int[0];

        int len = (int) Math.pow(10, n) - 1;
        resArr = new int[len];
        char[] numbers = new char[n];
        Arrays.fill(numbers, '0');

        for (int i = 0; i < 10; i++) {
            numbers[0] = (char) (i + '0');
            printNumRecursively(numbers, n, 0);
        }
        return resArr;
    }

    public void printNumRecursively(char[] numbers, int len, int index) {
        if (index == len - 1) {
            // add to arr
            addToArr(numbers);
            return;
        }

        for (int i = 0; i < 10; i++) {
            numbers[index + 1] = (char) (i + '0');
            printNumRecursively(numbers, len, index + 1);
        }
    }

    public void addToArr(char[] numbers) {
        boolean isBeginning = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (!isBeginning && numbers[i] != '0') {
                isBeginning = true;
            }
            if (isBeginning) {
                sb.append(numbers[i]);
            }
        }
        if (isBeginning) {
            resArr[count++] = Integer.parseInt(sb.toString());
        }
    }
}
