package com.leetcode.demo.aug_18;

public class ReverseInt {

    public static void main(String[] args) {
        // 输入：x = 123
        //输出：321

        int num = -123;
        System.out.println(new ReverseInt().reverse2(num));
    }

    public int reverse(int x) {
        if (x == 0) return 0;
        boolean isNegative = false;
        long val = x;
        if (x <= 0) {
            val = (long) x * -1;
            isNegative = true;
        }
        StringBuilder sb = new StringBuilder();
        while (val != 0) {
            sb.append(val % 10);
            val = val / 10;
        }
        if (isNegative) {
            if (Long.parseLong(sb.toString()) * -1 < Integer.MIN_VALUE) return 0;
            return Integer.parseInt(sb.toString()) * -1;
        }
        if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE) return 0;
        return Integer.parseInt(sb.toString());
    }

    public int reverse2(int x) {
        int ret = 0;
        while (x != 0) {
            if (ret > Integer.MAX_VALUE / 10 || ret < Integer.MIN_VALUE / 10) {
                return 0;
            }

            int digit = x % 10;
            x = x / 10;
            ret = ret * 10 + digit;
        }
        return ret;
    }
}
