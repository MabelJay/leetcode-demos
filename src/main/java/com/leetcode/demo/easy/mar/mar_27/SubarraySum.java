package com.leetcode.demo.easy.mar.mar_27;

import java.util.*;

public class SubarraySum {

    public static void main(String[] args) {
        // 输入:nums = [1,2,3], k = 3
        //输出: 2
        int[] nums = {1, 2, 3};
        int[] num2 = {1, 1, 1};

        // [1,-1,0]
        //0
        int[] num3 = {1, -1, 0};
        System.out.println(new SubarraySum().subarraySum(nums, 3));
        System.out.println(new SubarraySum().subarraySum(num2, 2));
        System.out.println(new SubarraySum().subarraySum(num3, 0));
    }

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sumArr = new int[len];
        sumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i];
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < len; i++) {
            int key = sumArr[i] - k;
            if (map.containsKey(key)) count += map.get(key);
            map.put(sumArr[i], map.getOrDefault(sumArr[i], 0) + 1);
        }
        return count;
    }
}
