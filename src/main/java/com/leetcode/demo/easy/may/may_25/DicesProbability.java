package com.leetcode.demo.easy.may.may_25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DicesProbability {

    public static void main(String[] args) {
        // 输入: 1
        //输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]

        // 输入: 2
        //输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                set.add(i + j);
            }
        }
        System.out.println(set.size());
        System.out.println(set);

        System.out.println(Arrays.toString(new DicesProbability().dicesProbability(2)));
    }

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);

        for (int i = 2; i <= n; i++) {
            double[] tmpArr = new double[i * 5 + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmpArr[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmpArr;
        }
        return dp;
    }
}
