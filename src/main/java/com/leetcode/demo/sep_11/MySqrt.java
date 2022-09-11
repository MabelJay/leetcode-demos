package com.leetcode.demo.sep_11;

public class MySqrt {

    public static void main(String[] args) {
        // 输入：x = 4
        //输出：2

        // 输入：x = 8
        //输出：2
        System.out.println(new MySqrt().mySqrt2(1));
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;

        int low = 1, high = x / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == x / mid) return mid;
            else if (mid > x / mid && (mid - 1) < x / (mid - 1)) return mid - 1;
            else if (mid > x / mid) high = mid - 1;
            else low = mid + 1;
        }
        return 1;
    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;

        int low = 1, high = x;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
