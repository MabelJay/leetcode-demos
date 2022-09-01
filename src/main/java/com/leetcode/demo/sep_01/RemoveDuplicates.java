package com.leetcode.demo.sep_01;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        // 输入：nums = [0,0,1,1,1,2,2,3,3,4]
        //输出：5, nums = [0,1,2,3,4]

        int[] nums = {1, 1, 2};
        System.out.println(new RemoveDuplicates().removeDuplicates2(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int insertIndex = nums.length;
        for (int i = 1; i < insertIndex; ) {
            if (nums[i] == nums[i - 1]) {
                for (int j = i + 1; j < insertIndex; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[--insertIndex] = nums[i - 1];
            } else i++;
        }
//        System.out.println(Arrays.toString(nums));
        return insertIndex;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int fast = 1, slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
