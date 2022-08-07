package com.leetcode.demo.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLHS {
    public static void main(String[] args) {
        //输入：nums = [1,3,2,2,5,2,3,7]
        //输出：5
        //解释：最长的和谐子序列是 [3,2,2,2,3]
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 3, 1, 0, 0, 0, 3, 1, -1, 0, 1, 1, 0, 0, 1, 1, 2, 2, 2, 0, 1, 2, 2, 3, 2};
        System.out.println(new FindLHS().findLHS2(nums));
    }

    public int findLHS_bak(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int len = nums.length;
        int maxLen = 0;
        for (int i = 0; i < len - 1; i++) {
            int min = nums[i];
            int max = nums[i];
            int j = i + 1;
            int index = i;
            while (j < len) {
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
                if (max - min == 1) index = j;
                j++;
            }
            System.out.println("index=" + index + " i=" + i + " maxLen=" + (index - i + 1));
            maxLen = Math.max(index - i + 1, maxLen);
        }
        return maxLen;
    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1) {
                begin++;
            }
            if (nums[end] - nums[begin] == 1) {
                res = Math.max(res, end - begin + 1);
            }
        }
        return res;
    }

    public int findLHS2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key + 1) + map.get(key));
            }
        }
        return res;
    }
}
