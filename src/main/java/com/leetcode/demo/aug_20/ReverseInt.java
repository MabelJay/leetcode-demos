package com.leetcode.demo.aug_20;

public class ReverseInt {

    public static void main(String[] args) {
        // 输入：x = 123
        //输出：321

        // 输入：x = -123
        //输出：-321

        System.out.println(new ReverseInt().reverse(-123));
    }

    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            if (ret > Integer.MAX_VALUE / 10 || ret < Integer.MIN_VALUE / 10) return 0;
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
}
