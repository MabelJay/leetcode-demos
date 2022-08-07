package com.leetcode.demo.easy.jan.jan_5;

public class Divide {

    public static void main(String[] args) {
        System.out.println(new Divide().divide(-2147483648, 2));
        // -2147483648
        //2

        System.out.println(Integer.MIN_VALUE);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }

        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        if (dividend == 0) return 0;

        boolean rev = false;
        if (dividend > 0) {
            rev = true;
            dividend = -dividend;
        }

        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int left = 0, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (check(divisor, mid, dividend)) {
                ans = mid;
                if (mid == Integer.MAX_VALUE) break;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return rev ? -ans : ans;
    }

    public boolean check(int divisor, int mid, int divided) {
        int result = 0, add = divisor;
        while (mid != 0) {
            if ((mid & 1) != 0) {
                if (result < divided - add) return false;
                result += add;
            }
            if (mid != 1) {
                if (add < divided - add) {
                    return false;
                }
                add += add;
            }
            mid >>= 1;
        }
        return true;
    }
}
