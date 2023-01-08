package com.leetcode.demo.jan.day04;

public class MinSubArrayLen {

    public static void main(String[] args) {
        // 输入：target = 7, nums = [2,3,1,2,4,3]
        //输出：2

        // 输入：target = 4, nums = [1,4,4]
        //输出：1

        // 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
        //输出：0
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new MinSubArrayLen().minSubArrayLen(11, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int sum = 0;
        int left = 0, right = 0;
        int minLen = len + 1;

        while (right <= len) {
            if (sum >= target) {
                minLen = Math.min(minLen, right - left);
                sum -= nums[left];
                left++;
            } else {
                if (right < len) sum += nums[right];
                right++;
            }
        }
        return minLen > len ? 0 : minLen;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
