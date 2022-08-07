package com.leetcode.demo.easy.may.may_12;

public class FindNthDigit {

    public static void main(String[] args) {
        // 输入：n = 3
        //输出：3

        // 输入：n = 11
        //输出：0

        System.out.println(new FindNthDigit().findNthDigit4(1000000000));
    }

    public int findNthDigit(int n) {
        int startNum = 0;
        int index = 0;
        while (index <= n) {
            String temp = String.valueOf(startNum);
            if (index + temp.length() <= n) index += temp.length();
            else {
                for (int i = 0; i < temp.length(); i++) {
                    if (index == n) return (temp.charAt(i) - '0');
                    index++;
                }
            }
            startNum++;
        }
        return -1;
    }

    public int findNthDigit2(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public int findNthDigit3(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public int findNthDigit4(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }

        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
