package com.leetcode.demo.easy.may.may_28;

public class MinSubArrayLen {

    public static void main(String[] args) {
        // 输入：target = 7, nums = [2,3,1,2,4,3]
        //输出：2

        // 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
        //输出：0

        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(new MinSubArrayLen().minSubArrayLen(11, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 1;
        int sum = nums[left];

        int minLen = Integer.MAX_VALUE;
        while (left < right) {
            while (right < nums.length && sum < target) {
                sum += nums[right];
                right++;
            }
            if (sum >= target) minLen = Math.min(minLen, right - left);
            sum -= nums[left];
            left++;
        }
        return minLen > nums.length ? 0 : minLen;
    }
}
