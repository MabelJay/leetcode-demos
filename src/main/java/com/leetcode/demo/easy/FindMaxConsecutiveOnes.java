package com.leetcode.demo.easy;

import java.util.Map;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        // 输入：[1,1,0,1,1,1]
        //输出：3

        int[] arr = {1, 1, 0, 1, 1, 1};
        System.out.println(new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(arr));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxCount = 0, count = 0;
        int index = 0, len = nums.length;
        while (index < len) {
            while (index < len && nums[index] == 1) {
                index++;
                count++;
            }
            maxCount = Math.max(count, maxCount);
            count = 0;
            index++;
        }
        return maxCount;
    }
}
