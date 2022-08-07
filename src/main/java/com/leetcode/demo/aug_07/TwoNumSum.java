package com.leetcode.demo.aug_07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumSum {
    public static void main(String[] args) {
        // 输入：nums = [2,7,11,15], target = 9
        //输出：[0,1]
        //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        // [3,2,4]
        //6
        int[] num2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(new TwoNumSum().twoSum(num2, target2)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
