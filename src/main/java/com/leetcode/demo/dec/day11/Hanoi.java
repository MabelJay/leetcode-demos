package com.leetcode.demo.dec.day11;

public class Hanoi {

    public static void main(String[] args) {
        hanoi(3);
    }

    public static void hanoi(int n) {
        if (n > 0) {
            func(3, "左", "右", "中");
        }
    }

    public static void func(int i, String start, String end, String others) {
        if (i == 1) {
            System.out.println("Move 1 from " + start + " to " + end);
        } else {
            func(i - 1, start, others, end);
            System.out.println("Move " + i + " from " + start + " to " + end);
            func(i - 1, others, end, start);
        }
    }
}
