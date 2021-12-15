package com.leetcode.demo.easy;

public class CheckPerfectNumber {

    public static void main(String[] args) {
        System.out.println(new CheckPerfectNumber().checkPerfectNumber2(28));
    }

    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1;
        for (int i = 2; i < num - 1; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public boolean checkPerfectNumber2(int num) {
        if (num == 1) return false;
        double limit = Math.sqrt(num);
        int sum = 1;
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != limit) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }
}
