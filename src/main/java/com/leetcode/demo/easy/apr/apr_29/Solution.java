package com.leetcode.demo.easy.apr.apr_29;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] nums = {1739, 5391, 8247, 236, 5581, 11, 938, 58, 1884, 823, 686, 1760, 6498, 6513, 6316, 2867};
        System.out.println(new Solution().canPartitionKSubsets(nums, 6));
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        return dfs(nums, nums.length - 1, sum / k, 0, k, new boolean[nums.length]);
    }

    public static boolean dfs(int[] nums, int begin, int target, int curSum, int k, boolean[] used) {
        //剪枝1
        if (k == 1)
            return true;
        if (curSum == target)
            return dfs(nums, nums.length - 1, target, 0, k - 1, used);//找到了一个组合,还有k-1个.
        //剪枝4
        for (int i = begin; i >= 0; i--) {
            //使用过的元素就不能再使用了
            if (used[i])
                continue;
            //剪枝2
            if (curSum + nums[i] > target)
                continue;
            used[i] = true;//添加元素nums[i]
            if (dfs(nums, i - 1, target, curSum + nums[i], k, used))
                return true;//如果添加这个元素后，完成了题目要求，就return true.
            used[i] = false;//回溯
            while (i > 0 && nums[i - 1] == nums[i])//剪枝3
                i--;
        }
        return false;
    }
}