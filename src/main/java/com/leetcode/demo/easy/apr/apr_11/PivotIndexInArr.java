package com.leetcode.demo.easy.apr.apr_11;

import java.util.Arrays;

public class PivotIndexInArr {

    public static void main(String[] args) {
        // 输入：nums = [1, 7, 3, 6, 5, 6]
        //输出：3

        int[] arr = {2, 1, -1};

        // [-1,-1,0,1,1,0]
        int[] arr2 = {-1, -1, 0, 1, 1, 0};
        System.out.println(new PivotIndexInArr().pivotIndex(arr2));
    }

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] sumArr = new int[len + 2];
        sumArr[0] = 0;
        for (int i = 0; i < len; i++) {
            sumArr[i + 1] = sumArr[i] + nums[i];
        }
        System.out.println(Arrays.toString(sumArr));

        for (int i = 1; i <= len; i++) {
            if (sumArr[i - 1] == sumArr[len] - sumArr[i]) return i - 1;
        }
        return -1;
    }

    // if (nums == null || nums.length == 0) return -1;
    //        int len = nums.length;
    //        int[] preSum = new int[len];
    //        int[] laterSum = new int[len];
    //        for (int i = 0; i < len; i++) {
    //            if (i > 0) preSum[i] = preSum[i - 1] + nums[i];
    //            else {
    //                preSum[i] = nums[i];
    //            }
    //        }
    //        for (int i = len - 1; i >= 0; i--) {
    //            if (i == len - 1) {
    //                laterSum[i] = nums[i];
    //            } else {
    //                laterSum[i] = laterSum[i + 1] + nums[i];
    //            }
    //        }
    ////        System.out.println(Arrays.toString(preSum));
    ////        System.out.println(Arrays.toString(laterSum));
    //        for (int i = 0; i < len; i++) {
    //            if (preSum[i] == laterSum[i]) return i;
    //        }
    //        return -1;
}
