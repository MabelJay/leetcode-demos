package com.leetcode.demo.oct.day22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static void main(String[] args) {
        // 输入：nums = [100,4,200,1,3,2]
        //输出：4

        // 输入：nums = [0,3,7,2,5,8,4,6,0,1]
        //输出：9

        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new LongestConsecutive().longestConsecutive2(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int k : nums) {
            max = Integer.max(max, k);
            min = Integer.min(min, k);
        }
        System.out.println("max=" + max + " min=" + min);

        int[] hashArr = new int[max - min + 1];
        for (int num : nums) {
            hashArr[num - min]++;
        }
        System.out.println(Arrays.toString(hashArr));
        int count = 0;
        int tempCount = 0;
        for (int j : hashArr) {
            if (j > 0) {
                tempCount++;
                count = Math.max(tempCount, count);
            } else {
                tempCount = 0;
            }
        }
        return count;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int longestLen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curLen++;
                    curNum++;
                }

                longestLen = Math.max(longestLen, curLen);
            }
        }
        return longestLen;
    }
}
