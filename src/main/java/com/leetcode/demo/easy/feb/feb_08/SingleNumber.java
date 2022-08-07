package com.leetcode.demo.easy.feb.feb_08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {
        // 输入：nums = [1,2,1,3,2,5]
        //输出：[3,5]
        //解释：[5, 3] 也是有效的答案
        int[] nums = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(new SingleNumber().singleNumber(nums)));
        System.out.println(Arrays.toString(new SingleNumber().singleNumber2(nums)));
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(-6));
        System.out.println(6 & -6);
    }

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) res[index++] = entry.getKey();
        }
        return res;
    }

    public int[] singleNumber2(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }

        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }
}
