package com.leetcode.demo.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {
    public static void main(String[] args) {
        //输入：nums1 = [1,2,2,1], nums2 = [2,2]
        //输出：[2]
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(new ArrayIntersection().intersection2(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == nums2 || nums2 == null) return null;

        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }

        for (Integer num : nums2) {
            if (set.contains(num)) {
                set1.add(num);
            }
        }
        int len = set1.size();
        int[] arr = new int[len];
        int index = 0;
        for (Integer num : set1) {
            arr[index++] = num;
        }
        return arr;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length, len2 = nums2.length;
        int index = 0, index1 = 0, index2 = 0;
        int[] resArr = new int[len1 + len2];

        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] == nums2[index2]) {
                if (index == 0 || nums1[index1] != resArr[index - 1]) {
                    resArr[index++] = nums1[index1];
                }
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(resArr, 0, index);
    }
}

