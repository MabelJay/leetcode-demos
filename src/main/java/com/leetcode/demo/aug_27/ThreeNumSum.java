package com.leetcode.demo.aug_27;

import java.util.*;

public class ThreeNumSum {

    public static void main(String[] args) {
        // 输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]

        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {1, -1, -1, 0};
        int[] nums3 = {-2, 0, 0, 2, 2};
        System.out.println(new ThreeNumSum().threeSum(nums3));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            for (; left < right; left++) {
                if (left > i + 1 && nums[left] == nums[left - 1]) continue;
                while (left < right) {
                    if (left > i + 1 && nums[left] == nums[left - 1]) break;
                    if (nums[left] + nums[right] == -nums[i]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        left++;
                        right--;
                        resList.add(list);
                    } else if (nums[left] + nums[right] > -nums[i]) right--;
                    else break;
                }
            }
        }
        return resList;
    }
}
