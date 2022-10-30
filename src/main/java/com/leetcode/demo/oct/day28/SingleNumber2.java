package com.leetcode.demo.oct.day28;

public class SingleNumber2 {
    public static void main(String[] args) {
        // 输入：nums = [2,2,3,2]
        //输出：3

        // 输入：nums = [0,1,0,1,0,1,99]
        //输出：99
        int[] nums = {2, 2, 3, 2};
        System.out.println(new SingleNumber2().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
