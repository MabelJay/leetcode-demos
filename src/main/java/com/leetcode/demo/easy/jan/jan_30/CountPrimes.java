package com.leetcode.demo.easy.jan.jan_30;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes2(5000000));
    }

    public int countPrimes(int n) {
        if (n < 2) return 0;
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) count++;
        }
        return count;
    }

    public boolean isPrimes(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int countPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return count;
    }
}
