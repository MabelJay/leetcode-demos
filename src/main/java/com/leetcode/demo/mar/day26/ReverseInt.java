package com.leetcode.demo.mar.day26;

public class ReverseInt {

    public static void main(String[] args) {
        int x = -123;
        System.out.println(new ReverseInt().reverse2(x));

//        System.out.println((-12 % 10));
    }

    public int reverse(int x) {
        boolean isNegative = false;
        long input = x;
        if (x < 0) {
            isNegative = true;
            input = -x;
        }

        StringBuilder sb = new StringBuilder();
        while (input > 0) {
            int left = (int) input % 10;
            input = input / 10;
            if (left == 0 && sb.length() == 0) continue;
            sb.append(left);
        }
        if (sb.length() == 0) return 0;
        input = Long.parseLong(sb.toString());
        if (!isNegative) {
            if (input > Integer.MAX_VALUE) return 0;
        } else {
            input = -1 * input;
            if (input < Integer.MIN_VALUE) return 0;
        }
        return (int) input;
    }

    public int reverse2(int x) {
        int ret = 0;
        while (x != 0) {
            if (ret > Integer.MAX_VALUE / 10 || ret < Integer.MIN_VALUE / 10) return 0;

            int digit = x % 10;
            x /= 10;
            ret = ret * 10 + digit;
        }
        return ret;
    }
}
