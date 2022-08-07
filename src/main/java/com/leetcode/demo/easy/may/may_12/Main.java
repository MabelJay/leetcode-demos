package com.leetcode.demo.easy.may.may_12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(new Main().processInput(s));
        }
    }

    public int processInput(String s) {
        String[] arr = s.split(" ");
        return computeMultiple(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
    }

    public int computeMultiple(int num1, int num2) {
        if (num1 == 0 || num2 == 0) return 0;
//        return num1 * num2 / gcd(num1, num2);
        return num1 * num2 / gcd2(num1, num2);
    }

    public int gcd(int num1, int num2) {
        int reminder = num1 % num2;
        while (reminder != 0) {
            num1 = num2;
            num2 = reminder;
            reminder = num1 % num2;
        }
        return num2;
    }

    public int gcd2(int num1, int num2) {
        if (num2 == 0) return num1;
        return gcd2(num2, num1 % num2);
    }
}
