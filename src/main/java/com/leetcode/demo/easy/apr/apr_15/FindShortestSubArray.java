package com.leetcode.demo.easy.apr.apr_15;

import java.util.HashMap;
import java.util.Map;

public class FindShortestSubArray {

    public static void main(String[] args) {
        // 输入：nums = [1,2,2,3,1]
        //输出：2

        // 输入：nums = [1,2,2,3,1,4,2]
        //输出：6

        int[] nums = {1, 2, 2, 3, 1};

        // 输入：nums = [1,2,2,3,1,4,2]
        //输出：6

        int[] nums2 = {1, 2, 2, 3, 1, 4, 2};

        // [2,1]
        int[] nums3 = {2, 1};
        System.out.println(new FindShortestSubArray().findShortestSubArray(nums3));
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] arr;
            if (map.containsKey(nums[i])) {
                arr = map.get(nums[i]);
                arr[1] = i;
            } else {
                arr = new int[3];
                arr[0] = i;
                arr[1] = i;
            }
            arr[2]++;
            map.put(nums[i], arr);
            maxCount = Math.max(maxCount, arr[2]);
        }
        int minSegment = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            if (value[2] == maxCount) minSegment = Math.min(minSegment, value[1] - value[0] + 1);
        }
        return minSegment;
    }

    // if (nums == null || nums.length == 0) return 0;
    //
    //        int len = nums.length;
    //        // count frequency
    //        Map<Integer, int[]> map = new HashMap<>();
    //        for (int i = 0; i < len; i++) {
    //            int temp = nums[i];
    //            if (map.containsKey(temp)) {
    //                int[] tmpArr = map.get(temp);
    //                tmpArr[0]++;
    //                tmpArr[2] = i;
    //            } else {
    //                map.put(temp, new int[]{1, i, i});
    //            }
    //        }
    //
    //        int maxNum = 0, minLen = 0;
    //        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
    //            int[] tmpArr = entry.getValue();
    //            if (tmpArr[0] > maxNum) {
    //                maxNum = tmpArr[0];
    //                minLen = tmpArr[2] - tmpArr[1] + 1;
    //            } else if (tmpArr[0] == maxNum) {
    //                minLen = Math.min(minLen, tmpArr[2] - tmpArr[1] + 1);
    //            }
    //        }
    //        return minLen;
}
