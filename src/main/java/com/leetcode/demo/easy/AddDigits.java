package com.leetcode.demo.easy;

public class AddDigits {

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.addDigits2(38));
    }

    public int addDigits(int num) {
        if (num < 0 || isSingleNum(num)) return num;
        int sum = 0;
        while (true) {
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            if (isSingleNum(sum)) return sum;
            num = sum;
            sum = 0;
        }
    }

    public boolean isSingleNum(int num) {
        return num / 10 == 0;
    }

    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
