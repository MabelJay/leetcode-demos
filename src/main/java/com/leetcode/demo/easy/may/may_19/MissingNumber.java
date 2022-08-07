package com.leetcode.demo.easy.may.may_19;

public class MissingNumber {

    public static void main(String[] args) {
        // 输入: [0,1,2,3,4,5,6,7,9]
        //输出: 8

        int[] arr = {0};
        System.out.println(new MissingNumber().missingNum(arr));
    }

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public int missingNum(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
