package com.leetcode.demo.easy;

public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println(new SingleNumber().singleNumber(arr));
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (Integer num : nums) {
            res ^= num;
        }
        return res;
    }
}
