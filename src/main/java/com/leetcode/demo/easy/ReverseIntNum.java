package com.leetcode.demo.easy;

import java.util.Arrays;

public class ReverseIntNum {
    public static void main(String[] args) {
        int num1 = 123;
        int num2 = 2147483641;
        int num3 = -2147483648;
//        int num4 = 9646324351;
        //2147483647
        ReverseIntNum intNum = new ReverseIntNum();
//        System.out.println(intNum.reverse(num4));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(intNum.reverse2(num2));
    }

    public int reverse(int x) {
        boolean isMin = false;
        if (x == Integer.MIN_VALUE) {
            x = x / -2;
            isMin = true;
        }
        boolean isPositive = true;
        if (x < 0) {
            isPositive = false;
            x = x * -1;
        }
        String s = String.valueOf(x);
        char[] arr = s.toCharArray();
        int len = s.length();
        int center = (len - 1) / 2;
        if (len % 2 == 0) {
            for (int i = 0; i <= center; i++) {
                swap(arr, center - i, center + i + 1);
            }
        } else {
            for (int i = 0; i < center; i++) {
                swap(arr, center - i - 1, center + i + 1);
            }
        }
        x = Integer.parseInt(String.valueOf(arr));
        if (isMin) return x * -2;
        if (isPositive) return x;
        else return x * -1;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int reverse2(int x) {
        //2147483641
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public int reverse3(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
