package com.leetcode.demo.easy.may.may_12;

public class GcdOfThreeNums {

    public static void main(String[] args) {
        System.out.println(new GcdOfThreeNums().gcd2(3, 6));
    }

    public int gcd2(int num1, int num2) {
        int reminder = num1 % num2;
        while (reminder != 0) {
            num1 = num2;
            num2 = reminder;
            reminder = num1 % num2;
        }
        return num2;
    }


    public int gcd(int x, int y) {
        int reminder = x % y;
        while (reminder != 0) {
            x = y;
            y = reminder;
            reminder = x % y;
        }
        return y;
    }
}
