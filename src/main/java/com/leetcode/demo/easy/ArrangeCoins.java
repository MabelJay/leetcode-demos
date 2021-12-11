package com.leetcode.demo.easy;

public class ArrangeCoins {

    public static void main(String[] args) {
        System.out.println(new ArrangeCoins().arrangeCoins2(5));
    }

    public int arrangeCoins(int n) {
        if (n < 1) return 0;

        int temp = n;
        for (int i = 1; i <= n; i++) {
            temp -= i;
            if (temp == 0) {
                return i;
            } else if (temp < 0) {
                return i - 1;
            }
        }
        return temp;
    }

    public int arrangeCoins2(int n) {
        if (n < 1) return 0;

        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
