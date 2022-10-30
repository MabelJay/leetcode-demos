package com.leetcode.demo.oct.day28;

public class SingleNumber {
    public static void main(String[] args) {
        //输入: [2,2,1]
        //输出: 1
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new SingleNumber().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }
}
