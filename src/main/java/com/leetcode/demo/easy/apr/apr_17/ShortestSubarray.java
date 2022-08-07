package com.leetcode.demo.easy.apr.apr_17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ShortestSubarray {

    public static void main(String[] args) {
        // 输入：nums = [1], k = 1
        //输出：1

        // 输入：nums = [1,2], k = 4
        //输出：-1

        // 输入：nums = [2,-1,2], k = 3
        //输出：3

        int[] nums = {48, 99, 37, 4, -31};
        // [2,-1,2]
        //3

        System.out.println(new ShortestSubarray().shortestSubarray2(nums, 140));

        // [48,99,37,4,-31]
        //140
        //

        // [17,85,93,-45,-21]
        //150
    }

    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        long[] sum = new long[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] >= k) return 1;
            if (i == 0) sum[i] = nums[i];
            else sum[i] = sum[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(sum));
        int minLen = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            if (sum[i] >= k) minLen = Math.min(minLen, i + 1);
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] >= k) {
                    minLen = Math.min(minLen, i - j);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public int shortestSubarray2(int[] nums, int k) {
        int len = nums.length;
        long[] sum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            if (nums[i] == k) return 1;
            sum[i + 1] = sum[i] + (long) nums[i];
        }
        System.out.println(Arrays.toString(sum));
        LinkedList<Integer> queue = new LinkedList<>();

        int ans = len + 1;
        for (int j = 0; j <= len; j++) {
            while (!queue.isEmpty() && sum[j] < sum[queue.getLast()]) {
                queue.removeLast();
            }
            while (!queue.isEmpty() && sum[j] >= sum[queue.getFirst()] + k) {
                ans = Math.min(ans, j - queue.removeFirst());
            }

            queue.addLast(j);
        }
        return ans < len + 1 ? ans : -1;
    }
}
