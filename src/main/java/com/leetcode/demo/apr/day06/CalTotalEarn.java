package com.leetcode.demo.apr.day06;

public class CalTotalEarn {

    public static void main(String[] args) {
        int year = 10;
        double rate = 0.1;
        double initial = 200000;
        double yearlySaving = 180000;

        System.out.println(calEarnings(year, rate, initial, yearlySaving));
    }

    public static double calEarnings(int year, double rate, double initial, double yearlySaving) {
        double sum = initial;
        for (int i = 0; i < year; i++) {
            sum += sum * rate;
//            System.out.println("sum=" + sum);
            sum += yearlySaving;
        }
        return sum;
    }
}
