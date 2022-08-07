package com.leetcode.demo.easy.may.may_19;

import java.util.Arrays;

public class SingleNumbers {

    public static void main(String[] args) {
        // 输入：nums = [1,2,10,4,1,4,3,3]
        //输出：[2,10] 或 [10,2]

        // 输入：nums = [4,1,4,6]
        //输出：[1,6] 或 [6,1]

        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};
        System.out.println(Arrays.toString(new SingleNumbers().singleNumbers(nums)));
    }

    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int div = 1;
        while ((div & res) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) == 0) {
                a ^= num;
            } else b ^= num;
        }
        return new int[]{a, b};
    }
}
