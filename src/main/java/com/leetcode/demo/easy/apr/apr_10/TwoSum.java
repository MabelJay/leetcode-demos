package com.leetcode.demo.easy.apr.apr_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        // 输入：nums = [2,7,11,15], target = 9
        //输出：[0,1]
        //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

        int[] nums = {-1, -2, -3, -4, -5};
        // [-1,-2,-3,-4,-5]
        //-8
        System.out.println(Arrays.toString(new TwoSum().twoSum2(nums, -8)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] tmpArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmpArr);

        int left = 0, right = tmpArr.length - 1;
        while (left < right) {
            int sum = tmpArr[left] + tmpArr[right];
            if (sum < target) {
                left++;
            } else if (sum > target) right--;
            else break;
        }
        if (left < right) {
            int[] resArr = new int[2];
            Arrays.fill(resArr, -1);
            for (int i = 0; i < nums.length; i++) {
                if (resArr[0] == -1 && nums[i] == tmpArr[left]) resArr[0] = i;
                if (i != resArr[0] && nums[i] == tmpArr[right]) {
                    resArr[1] = i;
                    return resArr;
                }
            }
        }

        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    //HashMap<Integer, Integer> map = new HashMap<>();
    //        for (int i = 0; i < nums.length; i++) {
    //            if (map.containsKey(target - nums[i])) {
    //                return new int[]{map.get(target - nums[i]), i};
    //            } else {
    //                map.put(nums[i], i);
    //            }
    //        }
    //        return null;
}
