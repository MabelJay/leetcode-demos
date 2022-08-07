package com.leetcode.demo.easy.may.may_04;

public class Rob {

    public static void main(String[] args) {
        // 输入：[1,2,3,1]
        //输出：4

        // 输入：[2,7,9,3,1]
        //输出：12

        int[] arr = {2, 1, 1, 2};
        // [2,1]
        // [2,1,1,2]
        System.out.println(new Rob().rob(arr));
        System.out.println(new Rob().rob2(arr));
    }

    public int rob(int[] nums) {
        return dfs(nums, nums.length - 1);
    }

    public int dfs(int[] nums, int index) {
        if (index < 0) return 0;
        return Math.max(dfs(nums, index - 1), dfs(nums, index - 2) + nums[index]);
    }

    public int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int first = nums[0];
        int second = Math.max(first, nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(second, first + nums[i]);
            first = second;
            second = cur;
        }
        return second;
    }
}
