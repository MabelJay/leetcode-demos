package com.leetcode.demo.easy.mar.mar_16;

import java.util.*;

public class FindLonely {

    public static void main(String[] args) {
        // 输入：nums = [10,6,5,8]
        //输出：[10,8]

        int[] nums = {0};
        System.out.println(new FindLonely().findLonely(nums));
        System.out.println(new FindLonely().findLonely2(nums));
    }

    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int key = entry.getKey();
            if (count == 1 && !map.containsKey(key - 1) && !map.containsKey(key + 1)) {
                list.add(key);
            }
        }
        return list;
    }

    public List<Integer> findLonely2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && i < nums.length - 1) {
                if (nums[i + 1] - nums[i] > 1 && nums[i] - nums[i - 1] > 1) list.add(nums[i]);
            } else if (i == 0) {
                if (i + 1 == nums.length || nums[i + 1] - nums[i] > 1) list.add(nums[i]);
            } else if (i == nums.length - 1) {
                if (nums[i] - nums[i - 1] > 1) list.add(nums[i]);
            }
        }
        return list;
    }
}
