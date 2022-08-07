package com.leetcode.demo.easy.jan.jan_31;

import java.util.Arrays;

public class MinSubArrayLen {

    int minLen;

    public static void main(String[] args) {
        // 输入：target = 7, nums = [2,3,1,2,4,3]
        //输出：2
        //解释：子数组 [4,3] 是该条件下的长度最小的子数组。

        // 输入：target = 4, nums = [1,4,4]
        //输出：1

        // 7
        //[5]
        //15
        //[5,1,3,5,10,7,4,9,2,8]

        // 213
        //[12,28,83,4,25,26,25,2,25,25,25,12]

        // 80
        //[10,5,13,4,8,4,5,11,14,9,16,10,20,8]

        // 7
        //[2,3,1,2,4,3]

        // 15
        //[1,2,3,4,5]
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new MinSubArrayLen().minSubArrayLen2(15, nums));
        System.out.println(new MinSubArrayLen().minSubArrayLen(15, nums));
        System.out.println(new MinSubArrayLen().minSubArrayLen3(15, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 1;
        int len = nums.length;
        int minLength = len + 1;
        int sum = nums[start];
        while (start <= end) {
            while (end < len && sum < target) {
                sum += nums[end++];
            }
            if (sum >= target) {
                minLength = Math.min(minLength, end - start);
            } else break;
            if (start <= end) {
                sum -= nums[start++];
            }
        }
        return minLength == len + 1 ? 0 : minLength;
    }

    public int minSubArrayLen3(int target, int[] nums) {
        int start = 0, end = 0;
        int len = nums.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < len) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] sumArr = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i - 1];
        }
        System.out.println(Arrays.toString(sumArr));

        for (int i = 1; i <= len; i++) {
            int num = target + sumArr[i - 1];
            int bound = Arrays.binarySearch(sumArr, num);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= len) {
                ans = Math.min(ans, bound - i + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

