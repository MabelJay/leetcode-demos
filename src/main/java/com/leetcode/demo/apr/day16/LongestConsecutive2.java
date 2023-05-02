package com.leetcode.demo.apr.day16;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive2 {

    public static void main(String[] args) {
        // 输入：nums = [0,3,7,2,5,8,4,6,0,1]
        //输出：9

        // 输入：nums = [100,4,200,1,3,2]
        //输出：4
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new LongestConsecutive2().longestConsecutive(nums));

    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
