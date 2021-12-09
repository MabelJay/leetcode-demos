package com.leetcode.demo.easy;

public class IsPowerOfThree {

    public static void main(String[] args) {
        System.out.println(new IsPowerOfThree().isPowerOfFour3(2));
        int n = 4;
        while (n <= (Integer.MAX_VALUE / 4)) {
            n = n * 4;
        }
        System.out.println(n);
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n != 1) {
            if (n % 3 != 0) return false;
            n = n / 3;
        }
        return true;
    }

    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    public boolean isPowerOfFour2(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public boolean isPowerOfFour3(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
