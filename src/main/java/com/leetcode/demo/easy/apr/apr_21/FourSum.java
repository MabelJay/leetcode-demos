package com.leetcode.demo.easy.apr.apr_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        // 输入：nums = [1,0,-1,0,-2,2], target = 0
        //输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        int[] nums = {1, 0, -1, 0, -2, 2};

        int[] nums2 = {2, 2, 2, 2, 2};

        int[] nums3 = {4, -9, -2, -2, -7, 9, 9, 5, 10, -10, 4, 5, 2, -4, -2, 4, -9, 5};

        // [1,0,-1,0,-2,2]
        //0
        //[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        // [-2,-1,-1,1,1,2,2]
        //0
        //[[-2,-1,1,2],[-1,-1,1,1]]

        // [-1,0,-5,-2,-2,-4,0,1,-2]
        //-9
        // [[-5,-4,-1,1],[-5,-4,0,0],[-5,-2,-2,0],[-4,-2,-2,-1]]

        // [4,-9,-2,-2,-7,9,9,5,10,-10,4,5,2,-4,-2,4,-9,5]
        //-13
        // [[-10,-9,-4,10],[-10,-9,2,4],[-9,-9,-4,9],[-9,-7,-2,5],[-9,-4,-2,2],[-7,-2,-2,-2]]
        System.out.println(new FourSum().fourSum(nums3, -13));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> list = new ArrayList<>();

        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                int sum = target - nums[i];
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                sum -= nums[j];
                int third = j + 1;
                int fourth = len - 1;

                while (third < fourth) {
                    while (third < fourth && third > j + 2 && nums[third] == nums[third - 1]) {
                        third++;
                    }
                    while (third < fourth && fourth < len - 1 && nums[fourth] == nums[fourth + 1]) {
                        fourth--;
                    }
                    if (third >= fourth) break;
                    if (nums[third] + nums[fourth] == sum) {
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(nums[i]);
                        tmpList.add(nums[j]);
                        tmpList.add(nums[third]);
                        tmpList.add(nums[fourth]);
                        list.add(tmpList);
                        third++;
                        fourth--;
                    } else if (nums[third] + nums[fourth] > sum) {
                        fourth--;
                    } else third++;
                }
            }
        }
        return list;
    }
}
