package com.leetcode.demo.easy;

public class IsPerfectSquare {

    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare().isPerfectSquare2(2147483647));
        System.out.println(Integer.MAX_VALUE);
    }

    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;

        int low = 1, high = num;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            long val = (long) mid * mid;
            if (val == num) return true;
            if (val < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        double x0 = num;
        while (true) {
            double x1 = (x0 + num / x0) / 2;
            if (x0 - x1 < 1e-6) {
                break;
            }
            x0 = x1;
        }
        int x = (int) x0;
        return x * x == num;
    }
}
