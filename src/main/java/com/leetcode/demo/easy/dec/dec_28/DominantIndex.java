package com.leetcode.demo.easy.dec.dec_28;

public class DominantIndex {

    public static void main(String[] args) {
        // 输入：nums = [3,6,1,0]
        //输出：1

        int[] nums = {1, 2, 3, 4};
        System.out.println(new DominantIndex().dominantIndex(nums));
    }

    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        int maxNum = Integer.MIN_VALUE;
        int secondMaxNum = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                index = i;
                secondMaxNum = maxNum;
                maxNum = nums[i];
            } else if (nums[i] > secondMaxNum) {
                secondMaxNum = nums[i];
            }
        }
        return maxNum >= (secondMaxNum * 2) ? index : -1;
    }
}
