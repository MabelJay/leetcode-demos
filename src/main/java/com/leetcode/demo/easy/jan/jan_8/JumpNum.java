package com.leetcode.demo.easy.jan.jan_8;

public class JumpNum {
    public static void main(String[] args) {
        // 输入: nums = [2,3,1,1,4]
        //输出: 2

        int[] nums = {0};
        System.out.println(new JumpNum().jump(nums));
    }

    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return dfs(nums, nums.length - 1);
    }

    public int dfs(int[] nums, int steps) {
        if (steps == 0) return 0;
        if (steps == 1) return 1;
        int temp = steps;
        for (int i = steps - 1; i >= 0; i--) {
            if (nums[i] >= (steps - i)) {
                temp = i;
            }
        }
        return 1 + dfs(nums, temp);
    }

    public int jump3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int pos = len - 1;
        int steps = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (i + nums[i] >= pos) {
                    pos = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public int jump(int[] nums) {
        int pos = 0, end = 0;
        int maxPos = 0;
        int step = 0;
        while (pos < nums.length - 1) {
            maxPos = Math.max(maxPos, nums[pos] + pos);
            if (maxPos >= nums.length - 1) return step + 1;
            if (pos == end) {
                end = maxPos;
                step++;
            }
            pos++;
        }
        return step;
    }
}
