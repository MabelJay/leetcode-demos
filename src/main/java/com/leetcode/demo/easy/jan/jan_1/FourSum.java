package com.leetcode.demo.easy.jan.jan_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {

        // 输入：nums = [1,0,-1,0,-2,2], target = 0
        //输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        int[] nums = {-1,0,1,2,-1,-4};

        // [-3,-1,0,2,4,5]
        //2
        // [[-3,-1,2,4]]

        //[-2,-1,-1,1,1,2,2]
        //0
        //[-1,0,1,2,-1,-4]
        //-1

        System.out.println(new FourSum().fourSum(nums, -1));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 4) return resList;

        Arrays.sort(nums);
        int first = 0;
        int len = nums.length;
        while (first < len - 3) {
            while (first > 0 && first < len - 3 && nums[first] == nums[first - 1]) {
                first++;
            }
            int sum = target - nums[first];
            int second = first + 1;
            while (second < len - 2 ) {
                while (second > first + 1 && second < len - 2 && nums[second] == nums[second - 1]) {
                    second++;
                }
                int third = second + 1;
                int four = len - 1;
                while (third < four) {
                    while (third > second + 1 && third < len - 1 && nums[third] == nums[third - 1]) {
                        third++;
                    }
                    while (third < four && nums[second] + nums[third] + nums[four] > sum) {
                        four--;
                    }
                    while (third < four && nums[second] + nums[third] + nums[four] < sum) {
                        third++;
                    }
                    if (third == four) {
                        break;
                    }
                    if (nums[third] + nums[second] + nums[four] == sum) {
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(nums[first]);
                        tmpList.add(nums[second]);
                        tmpList.add(nums[third]);
                        tmpList.add(nums[four]);
                        resList.add(tmpList);
                        third++;
                    }
                }
                second++;
            }
            first++;
        }
        return resList;
    }
}
