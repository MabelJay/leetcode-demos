package com.leetcode.demo.easy.jan.jan_24;

import java.util.*;

public class LongestConsecutive {

    public static void main(String[] args) {
        // 输入：nums = [100,4,200,1,3,2]
        //输出：4
        //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
        //示例 2：
        //
        //输入：nums = [0,3,7,2,5,8,4,6,0,1]
        //输出：9

        // [9,1,4,7,3,-1,0,5,8,-1,6]

        // [1,2,0,1]
        // 3
        int[] nums = {1, 2, 0, 1};
        System.out.println(new LongestConsecutive().longestConsecutive2(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        System.out.println(set);

        int maxCount = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int count = 1;

                while (set.contains(curNum + 1)) {
                    curNum++;
                    count++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) count++;
            else if (nums[i] == nums[i - 1]) continue;
            else count = 1;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
