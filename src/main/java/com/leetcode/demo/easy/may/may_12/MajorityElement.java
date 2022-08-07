package com.leetcode.demo.easy.may.may_12;

import java.util.*;

public class MajorityElement {

    public static void main(String[] args) {
        // 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
        //输出: 2

        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums2 = {2, 2};
        System.out.println(new MajorityElement().majorityElement4(nums2));
    }

    public int majorityElement4(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) return num;
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) {
        return partitionRec(nums, 0, nums.length - 1);
    }

    public int partitionRec(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = (left + right) / 2;
        int leftPart = partitionRec(nums, left, mid);
        int rightPart = partitionRec(nums, mid + 1, right);

        if (leftPart == rightPart) return leftPart;
        int leftCount = countInRange(nums, left, right, leftPart);
        int rightCount = countInRange(nums, left, right, rightPart);
        return leftCount > rightCount ? leftPart : rightPart;
    }

    public int countInRange(int[] nums, int indexOfLeft, int indexOfRight, int num) {
        int count = 0;
        for (int i = indexOfLeft; i <= indexOfRight; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }
}
