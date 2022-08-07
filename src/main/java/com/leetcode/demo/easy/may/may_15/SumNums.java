package com.leetcode.demo.easy.may.may_15;

public class SumNums {

    public static void main(String[] args) {
        // 输入: n = 3
        //输出: 6

        // 输入: n = 9
        //输出: 45

        System.out.println(new SumNums().sumNums3(9));
    }

    public int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }

    public int sumNums2(int n) {
        boolean flag = n > 0 && (n += sumNums2(n - 1)) > 0;
        return n;
    }

    public int sumNums3(int n) {
        int ans = 0, num1 = n, num2 = n + 1;

        boolean flag;
        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        flag = ((num2 & 1) > 0 && (ans += num1) > 0);
        num1 <<= 1;
        num2 >>= 1;

        return ans >> 1;

    }
}
