package com.leetcode.demo.aug_31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfFour {

    public static void main(String[] args) {
        // 输入：nums = [1,0,-1,0,-2,2], target = 0
        //输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        // [1000000000,1000000000,1000000000,1000000000]
        //-294967296
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new SumOfFour().fourSum(nums, -294967296));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                long target1 = (long) target - nums[i] - nums[j];

                int index1 = j + 1;
                int index2 = len - 1;
                while (index1 < index2) {
                    if (index1 > j + 1 && nums[index1] == nums[index1 - 1]) {
                        index1++;
                        continue;
                    }
                    if (nums[index1] + nums[index2] == target1) {
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(nums[i]);
                        tmpList.add(nums[j]);
                        tmpList.add(nums[index1]);
                        tmpList.add(nums[index2]);
                        list.add(tmpList);
                        index1++;
                        index2--;
                    } else if (nums[index1] + nums[index2] < target1) {
                        index1++;
                    } else index2--;
                }
            }
        }
        return list;
    }
}
