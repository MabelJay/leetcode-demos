package com.leetcode.demo.easy.apr.apr_30;

import java.util.Map;

public class MySqrt {

    public static void main(String[] args) {
        // 输入：x = 4
        //输出：2

        // 输入：x = 8
        //输出：2

        System.out.println(new MySqrt().mySqrt3(Integer.MAX_VALUE));
        System.out.println(new MySqrt().mySqrt2(Integer.MAX_VALUE));
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;
        int low = 1, high = x;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (mid == x / mid || (mid < x / mid && mid > x / (mid + 1) - 1)) return mid;
            else if (mid > x / mid) high = mid - 1;
            else low = mid + 1;
        }
        return 0;
    }

    public int mySqrt3(int x) {
        if (x == 0) return 0;
        int low = 1, high = x;
        int ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid <= x) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
