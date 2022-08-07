package com.leetcode.demo.easy.may.may_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        // 输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]
        int[] nums = {-1, 0, 1, 2, -1, -4};
        // [-2,0,0,2,2]
        System.out.println(new ThreeSum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) return list;

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int sum = -nums[i];
            int threeNum = nums.length - 1;
            int j = i + 1;
            while (j < threeNum) {
                if (nums[j] + nums[threeNum] == sum) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        j++;
                        continue;
                    }
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[j]);
                    tmpList.add(nums[threeNum]);
                    list.add(tmpList);
                    j++;
                    threeNum--;
                } else if (nums[j] + nums[threeNum] < sum) j++;
                else threeNum--;
            }
        }
        return list;
    }
}
