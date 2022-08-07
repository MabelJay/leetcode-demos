package com.leetcode.demo.easy.dec.dec_22;

import java.util.Arrays;

public class FindErrorNums {
    public static void main(String[] args) {
        // 输入：nums = [1,2,2,4]
        //输出：[2,3]

        // [2,3,2]
        // [2,1]

        int[] nums = {2, 3, 2};
        System.out.println(Arrays.toString(new FindErrorNums().findErrorNums2(nums)));
    }

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;

        int len = nums.length;
        int sum = (len + 1) * len / 2;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                res[0] = nums[i];
            } else {
                sum -= nums[i];
            }
        }
        res[1] = sum;
        return res;
    }

    public int[] findErrorNums2(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;

        int len = nums.length;
        int[] arr = new int[len];
        for (int num : nums) {
            int index = (num - 1) % len;
            arr[index]++;
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                res[1] = i + 1;
            }
            if (arr[i] == 2) {
                res[0] = i + 1;
            }
        }
        return res;
    }
}
