package com.leetcode.demo.easy.mar.mar_31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSums {

    public static void main(String[] args) {
        // 输入: nums = [5,6,5], target = 11
        //输出: [[5,6]]

        // 输入: nums = [5,6,5,6], target = 11
        //输出: [[5,6],[5,6]]

        int[] nums = {5, 6, 5, 6};
        System.out.println(new PairSums().pairSums(nums, 11));
    }

    public List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        List<List<Integer>> resList = new ArrayList<>();

        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(nums[left]);
                tmpList.add(nums[right]);
                resList.add(tmpList);
                left++;
                right--;
            }
        }
        return resList;
    }
}
