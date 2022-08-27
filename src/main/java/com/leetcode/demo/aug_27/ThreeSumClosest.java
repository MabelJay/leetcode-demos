package com.leetcode.demo.aug_27;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        // 输入：nums = [-1,2,1,-4], target = 1
        //输出：2

        int[] nums = {0, 0, 0};
        // [4,0,5,-5,3,3,0,-4,-5]
        //-2
        int[] nums2 = {4, 0, 5, -5, 3, 3, 0, -4, -5};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums2, -2));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));

        int diff = Integer.MAX_VALUE;
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int second = i + 1;
            int third = len - 1;
            while (second < third) {
                int sum = nums[i] + nums[second] + nums[third];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(diff - target)) {
                    diff = sum;
                }
                if (sum > target) {
                    int tmpIndex = third - 1;
                    while (tmpIndex > second && nums[tmpIndex] == nums[third]) {
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
        }
        return diff;
    }
}
