package com.leetcode.demo.easy.dec.dec_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        // 输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]
        int[] nums = {-1, 0, 1, 2, -1, 4};
        int[] nums2 = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};

        //[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
        System.out.println(new ThreeSum().threeSum(nums2));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) return list;

        int len = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int first = 0, second, third;
        while (first < len - 2) {
            while (first > 0 && first < len - 2 && nums[first] == nums[first - 1]) {
                first++;
            }
            int target = -nums[first];
            second = first + 1;
            third = len - 1;
            while (second < len - 1) {
                while (second > first + 1 && second < len - 1 && nums[second] == nums[second - 1]) {
                    second++;
                }

                while (second < third && nums[third] + nums[second] > target) {
                    third--;
                }

                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[first]);
                    tmpList.add(nums[second]);
                    tmpList.add(nums[third]);
                    list.add(tmpList);
                }

                second++;
            }
            first++;
        }
        return list;
    }
}
