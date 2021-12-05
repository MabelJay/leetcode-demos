package com.leetcode.demo.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNum {
    public static void main(String[] args) {
        System.out.println(new HappyNum().isHappy2(19));
    }

    public boolean isHappy(int n) {
        if (n < 0) return false;
        if (n == 0) return true;

        Set<Integer> set = new HashSet<>();
        int left;
        while (true) {
            int sum = 0;
            left = n;
            while (left != 0) {
                sum += (left % 10) * (left % 10);
                left = left / 10;
            }
            if (sum == 1) return true;
            if (set.contains(sum)) return false;
            else {
                set.add(sum);
            }
            n = sum;
        }
    }

    public boolean isHappy2(int n) {
        if (n < 0) return false;
        if (n < 2) return true;

        int slow = n, fast = getNext(n);
        while (slow != fast) {
            if (fast == 1) return true;
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }
        return false;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n = n / 10;
        }
        return sum;
    }
}
