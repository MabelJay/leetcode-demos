package com.leetcode.demo.easy.may.may_18;

public class ExerciseTest {

    public static void main(String[] args) {
        test(6);
    }

    public static void test(int x) {
        if (x >= 2) {
//            test(x - 1);
            test(--x);
//            test(x--);
        }
        System.out.println(x);
    }
}
