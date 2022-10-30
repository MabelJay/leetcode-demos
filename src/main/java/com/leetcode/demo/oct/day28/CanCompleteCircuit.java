package com.leetcode.demo.oct.day28;

import java.util.Arrays;

public class CanCompleteCircuit {
    public static void main(String[] args) {
        // 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        //输出: 3

        // [5,1,2,3,4]
        //[4,4,1,5,1]
        //4
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new CanCompleteCircuit().canCompleteCircuit2(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) return -1;
        int len = gas.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = gas[i] - cost[i];
        }

        for (int i = 0; i < len; i++) {
            if (dp[i] < 0) continue;
            int j = i + 1;
            int sum = dp[i];
            while (j < 2 * len) {
                int curIndex = j % len;
                sum += dp[curIndex];
                if (sum < 0) break;
                if (curIndex == i) return curIndex;
                j++;
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) return -1;
        int len = gas.length;

        int i = 0;
        while (i < len) {
            int count = 0;
            int left = 0;
            while (count < len) {
                int j = (i + count) % len;
                left += gas[j] - cost[j];
                if (left < 0) break;
                count++;
            }
            if (count == len) return i;
            else i = i + count + 1;
        }
        return -1;
    }
}
