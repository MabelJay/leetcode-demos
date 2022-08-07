package com.leetcode.demo.easy.apr.apr_10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        // 输入：nums = [1,2,3,1]
        //输出：true

        // 输入：nums = [1,2,3,4]
        //输出：false

        int[] nums = {1, 2, 3, 1};
        System.out.println(new ContainsDuplicate().containsDuplicate2(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }
}
