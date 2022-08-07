package com.leetcode.demo.easy.feb.feb_08;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class NthUglyNumber {
    public static void main(String[] args) {
        // [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
        System.out.println(new NthUglyNumber().isUglyNum(12));
        long startTime = System.currentTimeMillis();
        System.out.println(new NthUglyNumber().nthUglyNumber(1352));
        long endTime = System.currentTimeMillis();
        System.out.println("first method spends " + (endTime - startTime));
        System.out.println(new NthUglyNumber().nthUglyNumber2(1352));
        System.out.println("second method spends " + (System.currentTimeMillis() - endTime));
        System.out.println(new NthUglyNumber().nthUglyNumber3(1352));

    }

    public int nthUglyNumber(int n) {
        if (n == 1) return 1;

        int count = 0;
        int num = 1;
        while (count < n) {
            if (isUglyNum(num)) {
                count++;
            }
            if (count == n) return num;
            num++;
        }
        return -1;
    }

    public boolean isUglyNum(int num) {
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else if (num == 1) return true;
            else return false;
        }
        return true;
    }

    public int nthUglyNumber2(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1l);
        heap.add(1l);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur = heap.poll();
            ugly = (int) cur;
            for (int factor : factors) {
                long next = cur * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    public int nthUglyNumber3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = 2 * dp[p2];
            int num3 = 3 * dp[p3];
            int num5 = 5 * dp[p5];
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) p2++;
            if (dp[i] == num3) p3++;
            if (dp[i] == num5) p5++;
        }
        return dp[n];
    }
}
