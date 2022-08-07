package com.leetcode.demo.easy.feb.feb_19;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

    public static void main(String[] args) {
        // 输入：nums = [1,3,4,2,2]
        //输出：2

        // 输入：nums = [3,1,3,4,2]
        //输出：3

        // [2,2,2,2,2]
        // 2
        int[] nums = {3, 1, 3, 4, 2};

        // [9,4,9,5,7,2,8,9,3,9]
        System.out.println(new FindDuplicate().findDuplicate3(nums));
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return num;
        }
        return -1;
    }

    public int findDuplicate3(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
