package com.leetcode.demo.sep_03;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        // 输入：nums = [1,1,2]
        //输出：2, nums = [1,2,_]

        int[] nums = {1, 1, 2};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int fast = 1, slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
