package com.leetcode.demo.easy.apr.apr_29;

import java.util.Arrays;

public class CanPartitionKSubsets {

    public static void main(String[] args) {
        // 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
        //输出： True

        // 输入: nums = [1,2,3,4], k = 3
        //输出: false

        int[] nums = {1739, 5391, 8247, 236, 5581, 11, 938, 58, 1884, 823, 686, 1760, 6498, 6513, 6316, 2867};

        // [1,1,1,1,2,2,2,2]
        //4
        // true

        // [1739,5391,8247,236,5581,11,938,58,1884,823,686,1760,6498,6513,6316,2867]
        //6
        System.out.println(new CanPartitionKSubsets().canPartitionKSubsets(nums, 6));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(sum);
        return dfs(nums, sum / k, 0, 0, new boolean[nums.length], k);
    }

    public boolean dfs(int[] nums, int sum, int index, int curSum, boolean[] visited, int count) {
        if (count == 1) return true;
        if (curSum == sum) {
            return dfs(nums, sum, index, 0, visited, count - 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            if (curSum + nums[i] > sum) continue;
            visited[i] = true;
            if (dfs(nums, sum, index + 1, curSum + nums[i], visited, count)) return true;
            visited[i] = false;
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) i++;
        }
        return false;
    }
}
