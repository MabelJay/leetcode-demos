package com.leetcode.demo.easy;

public class FindPoisonedDuration {

    public static void main(String[] args) {
        //输入：timeSeries = [1,4], duration = 2
        //输出：4

        // 输入：timeSeries = [1,2,3], duration = 2
        //输出：4
        int[] series = {1, 2};
        System.out.println(new FindPoisonedDuration().find(series, 2));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        int sum = len * duration;
        for (int i = 1; i < len; i++) {
            int diff = timeSeries[i] - timeSeries[i - 1];
            sum -= diff >= duration ? 0 : (duration - diff);
        }
        return sum;
    }

    public int find(int[] timeSeries, int duration) {
        int ans = 0;
        int expired = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            if (timeSeries[i] >= expired) {
                ans += duration;
            } else {
                ans += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration;
        }
        return ans;
    }
}
