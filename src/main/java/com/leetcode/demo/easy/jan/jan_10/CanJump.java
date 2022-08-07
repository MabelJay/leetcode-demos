package com.leetcode.demo.easy.jan.jan_10;

public class CanJump {

    public static void main(String[] args) {
        // 输入：nums = [2,3,1,1,4]
        //输出：true

        // [2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6]
        int[] nums = {2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6};
        int[] nums2 = {0, 2, 3};
        System.out.println(new CanJump().canJump(nums2));
    }

    public boolean canJump2(int[] nums) {
        return dfs(nums, nums.length - 1);
    }

    public boolean dfs(int[] nums, int index) {
        if (index == 0) return true;
        if (index == 1) return nums[0] >= 1;

        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] + i >= index) {
                if (dfs(nums, i)) return true;
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) return true;
        int pos = 0, maxPos = 0;
        while (pos < nums.length - 1) {
            maxPos = Math.max(maxPos, pos + nums[pos]);
            if (maxPos >= nums.length - 1) return true;
            pos++;
            if (maxPos < pos) return false;
        }
        return false;
    }
}
