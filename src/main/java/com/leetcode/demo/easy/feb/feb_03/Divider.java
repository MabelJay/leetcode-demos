package com.leetcode.demo.easy.feb.feb_03;

public class Divider {

    public static void main(String[] args) {
        int num1 = 32;
        int num2 = 2;
        System.out.println(new Divider().divide(num1, num2));
    }

    public int divide(int num1, int num2) {
        boolean flag = false;
        if (num2 < 0) {
            flag = true;
            num2 = -num2;
        }
        if (num1 < 0) {
            flag = !flag;
            num1 = -num1;
        }
        if (num1 < num2) return 0;
        int temp = num2;
        int count = 1;
        int res = 0;
        while (num1 > 0) {
            res += count;
            num1 -= temp;
            temp <<= 1;
            count <<= 1;
            if (num1 < temp) {
                if (num1 >= num2) {
                    count = 1;
                    temp = num2;
                } else break;
            }
        }
        return flag ? -res : res;
    }
}
