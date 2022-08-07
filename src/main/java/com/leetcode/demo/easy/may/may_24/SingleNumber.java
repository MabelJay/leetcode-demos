package com.leetcode.demo.easy.may.may_24;

import java.util.*;

public class SingleNumber {

    public static void main(String[] args) {
        // 输入：nums = [3,4,3,3]
        //输出：4

        // 输入：nums = [9,1,7,9,7,9,7]
        //输出：1

        int[] nums = {3, 4, 3, 3};
        for (int num : nums) {
            System.out.println(Integer.toBinaryString(num));
        }
        System.out.println(new SingleNumber().singleNumber2(nums));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                bits[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= bits[31 - i] % 3;
        }
        return res;
    }
}
