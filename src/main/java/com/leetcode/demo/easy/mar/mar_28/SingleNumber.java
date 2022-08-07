package com.leetcode.demo.easy.mar.mar_28;

public class SingleNumber {

    public static void main(String[] args) {
        // 输入：nums = [2,2,3,2]
        //输出：3

        int[] nums = {2, 2, 3, 2};
        int[] nums2 = {0, 1, 0, 1, 0, 1, 100};
        System.out.println(new SingleNumber().singleNumber(nums));
        System.out.println(new SingleNumber().singleNumber(nums2));
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            if (total % 3 != 0) {
                ans += (1 << i);
            }
        }
        return ans;
    }
}
