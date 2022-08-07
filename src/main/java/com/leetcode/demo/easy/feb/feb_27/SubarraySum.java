package com.leetcode.demo.easy.feb.feb_27;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static void main(String[] args) {
        // 入：nums = [1,1,1], k = 2
        //输出：2

        // 输入：nums = [1,2,3], k = 3
        //输出：2

        // [1,-1,0]
        //0
        int[] nums = {1, -1, 0};
        System.out.println(new SubarraySum().subarraySum(nums, 0));
    }

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);
        int pre = 0;
        for (int i = 0; i < len; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
