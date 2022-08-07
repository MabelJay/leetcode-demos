package com.leetcode.demo.easy.apr.apr_11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        // 输入：numbers = [2,7,11,15], target = 9
        //输出：[1,2]

        int[] numbers = {2, 3, 4};
        System.out.println(Arrays.toString(new TwoSum().twoSum2(numbers, 6)));
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            map.put(numbers[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
            else if (numbers[left] + numbers[right] < target) {
                left++;
            } else right--;
        }
        return null;
    }

    //   int len = numbers.length;
    //        int left = 0, right = len - 1;
    //
    //        while (left < right) {
    //            if (numbers[left] + numbers[right] == target) {
    //                return new int[]{left + 1, right + 1};
    //            } else if (numbers[left] + numbers[right] < target) {
    //                left++;
    //            } else {
    //                right--;
    //            }
    //        }
    //        return new int[]{-1, -1};
}
