package com.leetcode.demo.easy.may.may_13;

import java.util.*;

public class Intersection2 {

    public static void main(String[] args) {
        // 输入：nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
        //输出：[3,4]
    }

    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (i == 0) map.put(nums[i][j], 1);
                else {
                    int key = nums[i][j];
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + 1);
                    }
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == nums.length) list.add(entry.getKey());
        }
        Collections.sort(list);
        return list;
    }
}
