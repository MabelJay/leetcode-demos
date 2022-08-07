package com.leetcode.demo.easy.may.may_28;

public class NumSubarrayProductLessThanK {

    public static void main(String[] args) {
        // 输入: nums = [10,5,2,6], k = 100
        //输出: 8

        // 输入: nums = [1,2,3], k = 0
        //输出: 0

        int[] nums = {1, 2, 3};
        System.out.println(new NumSubarrayProductLessThanK().numSubarrayProductLessThanK(nums, 0));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int sum = 1;
        int count = 0;

        while (right < nums.length) {
            sum *= nums[right];
            while (left <= right && sum >= k) {
                sum /= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
