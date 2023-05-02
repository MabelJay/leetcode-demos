package com.leetcode.demo.apr.day17;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GetKthMagicNumber {

    public static void main(String[] args) {
        // 输入: k = 5
        // 1，3，5，7，9，15，21
        //输出: 9
        System.out.println(new GetKthMagicNumber().getKthMagicNumber3(643));
    }

    private int getKthMagicNumber3(int k) {
        int[] seeds = {3, 5, 7};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.add(1L);
        set.add(1L);

        while (!queue.isEmpty()) {
            long tmpVal = queue.poll();
            if (--k == 0) return (int) tmpVal;
            for (int seed : seeds) {
                if (!set.contains(seed * tmpVal)) {
                    queue.add(seed * tmpVal);
                    set.add(seed * tmpVal);
                }
            }
        }
        return -1;
    }

    public int getKthMagicNumber(int k) {
        int[] ans = new int[k + 1];
        ans[1] = 1;
        int i3 = 1, i5 = 1, i7 = 1;

        int index = 2;
        while (index <= k) {
            int num1 = ans[i3] * 3;
            int num2 = ans[i5] * 5;
            int num3 = ans[i7] * 7;

            int min = Math.min(num1, Math.min(num2, num3));
            if (min == num1) i3++;
            if (min == num2) i5++;
            if (min == num3) i7++;
            ans[index++] = min;
        }
        return ans[k];
    }

    private int getKthMagicNumber2(int k) {
        int[] ans = new int[k + 1];
        ans[1] = 1;
        int i3 = 1, i5 = 1, i7 = 1;

        int index = 2;
        while (index <= k) {
            int num1 = ans[i3] * 3;
            int num2 = ans[i5] * 5;
            int num3 = ans[i7] * 7;

            int min = Math.min(num1, Math.min(num2, num3));
            if (min == num1) i3++;
            if (min == num2) i5++;
            if (min == num3) i7++;
            ans[index] = min;
            index++;
        }
        return ans[k];
    }
}
