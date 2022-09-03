package com.leetcode.demo.sep_03;

public class Divide {

    public static void main(String[] args) {
        // 输入: dividend = 10, divisor = 3
        //输出: 3

        System.out.println(new Divide().divide(10, 3));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return dividend;
            if (divisor == -1) return Integer.MAX_VALUE;
        }

        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        if (dividend == 0) return 0;

        boolean negative = false;
        if (dividend > 0) {
            dividend = -dividend;
            negative = !negative;
        }

        if (divisor > 0) {
            divisor = -divisor;
            negative = !negative;
        }

        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                ans = mid;
                if (ans == Integer.MAX_VALUE) break;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return negative ? -ans : ans;
    }

    public boolean quickAdd(int y, int z, int x) {
        // z * y >= x
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // result + add > = x
                if (result < x - add) return false;
                result += add;
            }
            if (z != 1) {
                // add + add > x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            z >>= 1;
        }
        return true;
    }
}
