package com.leetcode.demo.easy.june.june_27;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum4 {

    int count = 0;

    public static void main(String[] args) {
        // 输入：nums = [1,2,3], target = 4
        //输出：7
        //解释：
        //所有可能的组合为：
        //(1, 1, 1, 1)
        //(1, 1, 2)
        //(1, 2, 1)
        //(1, 3)
        //(2, 1, 1)
        //(2, 2)
        //(3, 1)

        int[] nums = {1, 2, 3};
        System.out.println(new CombinationSum4().combinationSum4(nums, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public void dfs(int[] nums, int target, int index, List<Integer> combine) {
        if (target == 0) {
            System.out.println(combine);
            count++;
            return;
        }

        if (index == nums.length || index < 0) return;

        if (nums[index] <= target) {
            combine.add(nums[index]);
            dfs(nums, target - nums[index], index, combine);
            combine.remove(combine.size() - 1);
        }

        dfs(nums, target, index + 1, combine);
    }
}
