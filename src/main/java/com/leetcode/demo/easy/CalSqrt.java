package com.leetcode.demo.easy;

public class CalSqrt {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(new CalSqrt().mySqrt3(x));
    }

    public int mySqrt(int x) {
        if (x <= 0) return 0;

        int left = 1, right = x;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (x / mid > mid) {
                left = mid + 1;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else return mid;
        }
        return left - 1;
    }

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }

        double x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + x / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
