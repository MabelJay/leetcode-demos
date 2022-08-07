package com.leetcode.demo.easy.may.may_08;

import java.util.*;

public class FindDuplicates {

    public static void main(String[] args) {
        // 输入：nums = [4,3,2,7,8,2,3,1]
        //输出：[2,3]

        // 输入：nums = [4,3,2,7,8,2,3,1]
        //输出：[2,3]

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new FindDuplicates().findDuplicates2(nums));
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

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) list.add(nums[i]);
        }
        return list;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
