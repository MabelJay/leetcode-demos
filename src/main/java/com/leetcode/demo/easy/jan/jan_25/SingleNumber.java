package com.leetcode.demo.easy.jan.jan_25;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {
        // 输入：nums = [0,1,0,1,0,1,99]
        //输出：99

        // [30000,500,100,30000,100,30000,100]
        int[] nums = {30000, 500, 100, 30000, 100, 30000, 100};
        System.out.println(new SingleNumber().singleNumber(nums));
        System.out.println(new SingleNumber().singleNumber2(nums));
//        compute(nums);
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int res = nums[0];
        for (int i : nums) {
            res |= i;
        }
        return res;
    }

    public static void compute(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res |= nums[i];
        }
        System.out.println(res);
    }
}
