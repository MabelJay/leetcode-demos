package com.leetcode.demo.nov.day24;

import java.util.Arrays;

public class PrintNumbers {

    int count = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrintNumbers().printNumbers(3)));
    }

    public int[] printNumbers(int n) {
        if (n <= 0) return new int[0];

        int arrLen = (int) (Math.pow(10, n) - 1);
        int[] resArr = new int[arrLen];
        char[] number = new char[n];
        Arrays.fill(number, '0');

        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            print1ToMaxRecursively(number, n, 0, resArr);
        }
        return resArr;
    }

    public void print1ToMaxRecursively(char[] numbers, int n, int index, int[] arr) {
        if (index == n - 1) {
            printNum(numbers, arr);
            return;
        }

        for (int i = 0; i < 10; i++) {
            numbers[index + 1] = (char) (i + '0');
            print1ToMaxRecursively(numbers, n, index + 1, arr);
        }
    }

    public void printNum(char[] number, int[] arr) {
        boolean isBeginning = true;

        StringBuilder sb = new StringBuilder();
        for (char c : number) {
            if (isBeginning && c != '0') {
                isBeginning = false;
            }

            if (!isBeginning) {
                sb.append(c);
            }
        }
        if (!isBeginning) {
            arr[count++] = Integer.parseInt(sb.toString());
        }
    }
}
