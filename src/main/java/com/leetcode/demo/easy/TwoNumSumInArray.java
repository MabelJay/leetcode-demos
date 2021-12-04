package com.leetcode.demo.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumSumInArray {

    public static void main(String[] args) {
        // numbers = [2,7,11,15], target = 9
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new TwoNumSumInArray().twoSum2(nums, 9)));
    }

    // O(n)
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0) return res;
        int index = 0;

        Map<Integer, Integer> map = new HashMap<>();
        while (index < numbers.length) {
            int temp = target - numbers[index];
            if (map.containsKey(temp)) {
                res[0] = map.get(temp) + 1;
                res[1] = index + 1;
                return res;
            } else {
                if (!map.containsKey(numbers[index])) {
                    map.put(numbers[index], index);
                }
            }
            index++;
        }
        return res;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0, right = len - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum3(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;

        int len = numbers.length;
        int right = len - 1;

        for (int i = 0; i < len; i++) {
            int temp = numbers[i];
            int left = i + 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (numbers[mid] == (target - temp)) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < (target - temp)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
