package com.leetcode.demo.easy.june.june_27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static void main(String[] args) {
        // 输入：nums = [100,4,200,1,3,2]
        //输出：4

        int[] nums = {100, 4, 200, 1, 3, 2};
        // [1,2,0,1]
        int[] nums2 = {1, 2, 0, 1};
        System.out.println(new LongestConsecutive().longestConsecutive(nums2));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longestLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;

                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curLen++;
                }
                longestLen = Math.max(longestLen, curLen);
            }
        }
        return longestLen;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int longestLen = 1;

        int curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                curLen++;
                longestLen = Math.max(curLen, longestLen);
            } else if (nums[i] - nums[i - 1] > 1) {
                curLen = 1;
            }
        }
        return longestLen;
    }
}
