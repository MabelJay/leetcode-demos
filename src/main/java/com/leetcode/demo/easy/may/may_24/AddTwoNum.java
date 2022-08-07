package com.leetcode.demo.easy.may.may_24;

public class AddTwoNum {

    public static void main(String[] args) {
        System.out.println(new AddTwoNum().add2(1, 1));
    }

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public int add2(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
