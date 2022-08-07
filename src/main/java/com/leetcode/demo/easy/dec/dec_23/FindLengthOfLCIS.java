package com.leetcode.demo.easy.dec.dec_23;

public class FindLengthOfLCIS {

    public static void main(String[] args) {
        // 输入：nums = [1,3,5,4,7]
        //输出：3
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS3(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 1;
        int len = nums.length;
        int index = 1;
        int temp = nums[0];
        int count;
        while (index < len) {
            count = 1;
            while (index < len && nums[index] > temp) {
                count++;
                temp = nums[index++];
            }
            maxLen = Math.max(maxLen, count);
            if (index == len) return maxLen;
            temp = nums[index];
            index++;
        }
        return maxLen;
    }

    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            while (i > 0 && i < nums.length && nums[i] > nums[i - 1]) {
                count++;
                i++;
            }
            maxLen = Math.max(count, maxLen);
        }
        return maxLen;
    }

    public int findLengthOfLCIS3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}
