package com.leetcode.demo.easy.may.may_07;

public class NumWays {

    public static void main(String[] args) {
        // 输入：n = 7
        //输出：21

        // 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
        // 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法

        // 46
        // 971215059
        int num = 1000000007;
        System.out.println(Long.MAX_VALUE > 6246583658587674878L);

        System.out.println(new NumWays().numWays(46));
    }

    public int numWays(int n) {
        if (n < 2) return 1;

        int firstNum = 1;
        int secondNum = 2;
        for (int i = 3; i <= n; i++) {
            int curCount = (firstNum + secondNum) % 1000000007;
            firstNum = secondNum;
            secondNum = curCount;
        }
        System.out.println(secondNum);
        return secondNum % 1000000007;
    }
}
