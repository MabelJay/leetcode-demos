package com.leetcode.demo.easy.may.may_28;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        // 输入：numbers = [1,2,4,6,10], target = 8
        //输出：[1,3]

        // 输入：numbers = [2,3,4], target = 6
        //输出：[0,2]

        int[] nums = {-1, 0};
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, -1)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] == target) return new int[]{low, high};
            else if (numbers[low] + numbers[high] > target) high--;
            else low++;
        }
        return new int[]{-1, -1};
    }
}
