package com.leetcode.demo.easy;

import java.util.Random;

public class GuessNumber {

    private static int targetNum;

    public static void main(String[] args) {
        targetNum = new Random().nextInt(11);
        System.out.println(targetNum);
        System.out.println(new GuessNumber().guessNumber(10));
    }

    public int guessNumber(int n) {
        if (n <= 1) return n;

        int low = 1, high = n;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int guess(int num) {
        if (num < targetNum) return 1;
        else if (num > targetNum) return -1;
        return 0;
    }
}
