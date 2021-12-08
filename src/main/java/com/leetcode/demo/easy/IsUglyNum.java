package com.leetcode.demo.easy;

import java.util.ArrayList;
import java.util.List;

public class IsUglyNum {

    public static void main(String[] args) {
        IsUglyNum uglyNum = new IsUglyNum();
        System.out.println(uglyNum.isUgly(3));
    }

    public boolean isUgly(int n) {
        if (n <= 0) return false;

        while (true) {
            if (n == 1) return true;
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
    }

    public boolean isUgly3(int n) {
        if (n <= 0) return false;

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);

        for (Integer val : list) {
            while (n % val == 0) {
                n /= val;
            }
        }
        return n == 1;
    }

    public boolean isUgly2(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
