package com.leetcode.demo.easy.dec.dec_25;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        // 输入：nums = [-1,2,1,-4], target = 1`
        //输出：2

        //[-3,-2,-5,3,-4]
        //-1

        int[] nums = {-3, -2, -5, 3, -4};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, -1));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int first = 0, second, third;
        int minDiff = 10000000;
        while (first < len - 2) {
            while (first < len - 2 && first > 0 && nums[first] == nums[first - 1]) {
                first++;
            }
            second = first + 1;
            third = len - 1;
            while (second < third) {
                while (second < len - 1 && second > first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                }
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) return sum;
                if (Math.abs(minDiff - target) > Math.abs(sum - target)) {
                    minDiff = sum;
                }
                if (sum > target) {
                    int tmpIndex = third - 1;
                    while (tmpIndex > second && nums[third] == nums[tmpIndex]) {
                        tmpIndex--;
                    }
                    third = tmpIndex;
                } else {
                    int tmpIndex = second + 1;
                    while (tmpIndex < third && nums[tmpIndex] == nums[second]) {
                        tmpIndex++;
                    }
                    second = tmpIndex;
                }
            }
            first++;
        }
        return minDiff;
    }
}
