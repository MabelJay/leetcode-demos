package com.leetcode.demo.easy.dec.dec_28;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        // 输入：cost = [10,15,20]
        //输出：15

        //输入：cost = [1,100,1,1,1,100,1,1,100,1]
        //输出：6
        int[] cost = {10, 15, 20};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs3(cost));
    }

    public int minCostClimbingStairs2(int[] cost) {
        return minCost(cost, cost.length);
    }

    public int minCost(int[] cost, int n) {
        if (n == 0 || n == 1) return 0;
        if (n == 2) return Math.min(cost[0], cost[1]);
        return Math.min(minCost(cost, n - 1) + cost[n - 1], minCost(cost, n - 2) + cost[n - 2]);
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] res = new int[len + 1];
        res[0] = res[1] = 0;
        for (int i = 2; i <= len; i++) {
            res[i] = Math.min(res[i - 1] + cost[i - 1], res[i - 2] + cost[i - 2]);
        }
        return res[len];
    }

    public int minCostClimbingStairs3(int[] cost) {
        int len = cost.length;
        int preToLast = 0;
        int pre = 0;
        for (int i = 2; i <= len; i++) {
            int temp = Math.min(preToLast + cost[i - 2], pre + cost[i - 1]);
            preToLast = pre;
            pre = temp;
        }
        return pre;
    }
}
