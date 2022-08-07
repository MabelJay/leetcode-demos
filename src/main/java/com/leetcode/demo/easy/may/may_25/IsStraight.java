package com.leetcode.demo.easy.may.may_25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsStraight {

    public static void main(String[] args) {
        // 输入: [1,2,3,4,5]
        //输出: True

        // 输入: [0,0,1,2,5]
        //输出: True

        int[] nums = {0, 0, 1, 2, 5};
        System.out.println(new IsStraight().isStraight2(nums));
    }

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) continue;
            if (set.contains(num)) return false;
            set.add(num);
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return max - min < 5;
    }

    public boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) joker++;
            else if (nums[i] == nums[i + 1]) return false;
        }
        System.out.println("joker=" + joker);
        return nums[nums.length - 1] - nums[joker] < 5;
    }
}
