package com.leetcode.demo.easy.feb.feb_25;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum {

    public static void main(String[] args) {
        // 输入：nums = [23,2,4,6,7], k = 6
        //输出：true
        int[] nums = {23, 2, 4, 6, 6};

        // [23,2,4,6,6]
        //7
        // true

        // [0]
        //1

        // [1,3,6,0,9,6,9]
        //7
        System.out.println(new CheckSubarraySum().checkSubarraySum(nums, 7));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int reminder = 0;
        for (int i = 0; i < len; i++) {
            reminder = (reminder + nums[i]) % k;
            if (map.containsKey(reminder)) {
                int preIndex = map.get(reminder);
                if (i - preIndex >= 2) return true;
            } else {
                map.put(reminder, i);
            }
        }
        return false;
    }
}
