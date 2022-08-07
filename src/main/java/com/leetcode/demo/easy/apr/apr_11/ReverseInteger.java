package com.leetcode.demo.easy.apr.apr_11;

public class ReverseInteger {

    public static void main(String[] args) {
        // 输入：x = 123
        //输出：321

        long temp = Integer.MIN_VALUE * -1L;
        System.out.println(temp);
        int x = Integer.MIN_VALUE;
        System.out.println(new ReverseInteger().reverse2(x));
    }

    public int reverse(int x) {
        boolean isNegative = false;
        long temp = x;
        if (x < 0) {
            isNegative = true;
            temp = x * -1L;
        }

        StringBuilder sb = new StringBuilder(String.valueOf(temp));
        temp = Long.parseLong(sb.reverse().toString());
        if (temp < Integer.MIN_VALUE || temp > Integer.MAX_VALUE) return 0;
        return isNegative ? (int) temp * -1 : (int) temp;
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) return 0;

            int digit = x % 10;
            x = x / 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
    // int rev = 0;
    //        while (x != 0) {
    //            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
    //                return 0;
    //            }
    //            int digit = x % 10;
    //            x /= 10;
    //            rev = rev * 10 + digit;
    //        }
    //        return rev;
}
