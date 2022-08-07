package com.leetcode.demo.easy.feb.feb_22;

import java.util.*;

public class FindDuplicatesTwo {

    public static void main(String[] args) {
        // 输入：nums = [4,3,2,7,8,2,3,1]
        //输出：[2,3]

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new FindDuplicatesTwo().findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) list.add(num);
            else set.add(num);
        }

        return list;
    }
}
