package com.leetcode.demo.easy;

public class IsPowerOfTwo {

    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        System.out.println(isPowerOfTwo.isPowerOfTwo3(1));
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n <= 0 || n % 2 != 0) return false;

        int val = 1;
        while (true) {
            if (val == n) return true;
            else if (val > n) return false;
            val = val * 2;
        }
    }

    public boolean isPowerOfTwo2(int n) {
        if (n == 1 || n == 2) return true;
        if (n <= 0 || n % 2 != 0) return false;

        return isPowerOfTwo2(n / 2);
    }

    public boolean isPowerOfTwo3(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
