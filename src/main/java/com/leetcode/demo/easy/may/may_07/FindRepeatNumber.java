package com.leetcode.demo.easy.may.may_07;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {

    public static void main(String[] args) {
        // 输入：
        //[2, 3, 1, 0, 2, 5, 3]
        //输出：2 或 3

        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(new FindRepeatNumber().findRepeatNumber3(nums));
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }

    public int findRepeatNumber3(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            arr[num]++;
            if (arr[num] > 1) return num;
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);
        return slow;
    }
}
