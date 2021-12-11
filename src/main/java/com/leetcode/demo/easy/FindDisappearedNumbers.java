package com.leetcode.demo.easy;

import java.util.*;

public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = {5, 4, 6, 7, 9, 3, 10, 9, 5, 6};
        System.out.println(new FindDisappearedNumbers().findDisappearedNumbers3(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }
        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) list.add(i);
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;

        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;

        int len = nums.length;
        for (int val : nums) {
            int index = (val - 1) % len;
            nums[index] += len;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
