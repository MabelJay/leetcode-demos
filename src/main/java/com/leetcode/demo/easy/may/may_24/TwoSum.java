package com.leetcode.demo.easy.may.may_24;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        // 输入：nums = [2,7,11,15], target = 9
        //输出：[2,7] 或者 [7,2]

        // 输入：nums = [10,26,30,31,47,60], target = 40
        //输出：[10,30] 或者 [30,10]

        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new TwoSum().twoSum2(nums, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int sum = nums[left] + nums[right];
        while (left < right) {
            if (sum < target) {
                sum -= nums[left];
                left++;
                sum += nums[left];
            } else if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else {
                sum -= nums[right];
                right--;
                sum += nums[right];
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return new int[]{nums[left], nums[right]};
            else if (sum > target) {
                right--;
            } else left++;
        }
        return new int[0];
    }
}
