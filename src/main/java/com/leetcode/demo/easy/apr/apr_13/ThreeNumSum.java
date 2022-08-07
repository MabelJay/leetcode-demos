package com.leetcode.demo.easy.apr.apr_13;

import com.leetcode.demo.easy.dec.dec_25.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum {

    public static void main(String[] args) {

        // 输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]

        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0};

        // [-2,0,0,2,2]
        // {-2,0,2}

        // [-1,0,1,2,-1,-4]
        int[] nums3 = {-2, 0, 0, 2, 2};
        int[] num4 = {-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeNumSum().threeSum2(num4));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            int leftSum = -nums[i];
            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                if (nums[left] + nums[right] == leftSum) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    res.add(tmpList);

                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < leftSum) {
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                } else {
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) return list;

        int len = nums.length;
        Arrays.sort(nums);

        int first = 0, second, third;
        while (first < len - 2) {
            while (first > 0 && first < len - 2 && nums[first] == nums[first - 1]) {
                first++;
            }
            int target = -nums[first];
            second = first + 1;
            third = len - 1;
            while (second < third) {
                while (second > first + 1 && second < third && nums[second] == nums[second - 1]) {
                    second++;
                }

                while (second < third && nums[third] + nums[second] > target) {
                    third--;
                }
                if (second == third) break;

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

    // List<List<Integer>> list = new ArrayList<>();
    //        if (nums == null || nums.length < 3) return list;
    //
    //        int len = nums.length;
    //        Arrays.sort(nums);
    //        //System.out.println(Arrays.toString(nums));
    //        int first = 0, second, third;
    //        while (first < len - 2) {
    //            while (first > 0 && first < len - 2 && nums[first] == nums[first - 1]) {
    //                first++;
    //            }
    //            int target = -nums[first];
    //            second = first + 1;
    //            third = len - 1;
    //            while (second < len - 1) {
    //                while (second > first + 1 && second < len - 1 && nums[second] == nums[second - 1]) {
    //                    second++;
    //                }
    //
    //                while (second < third && nums[third] + nums[second] > target) {
    //                    third--;
    //                }
    //
    //                if (second == third) {
    //                    break;
    //                }
    //                if (nums[second] + nums[third] == target) {
    //                    List<Integer> tmpList = new ArrayList<>();
    //                    tmpList.add(nums[first]);
    //                    tmpList.add(nums[second]);
    //                    tmpList.add(nums[third]);
    //                    list.add(tmpList);
    //                }
    //
    //                second++;
    //            }
    //            first++;
    //        }
    //        return list;
}
