package com.leetcode.demo.easy;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayIntersect {

    public static void main(String[] args) {
        //输入：nums1 = [1,2,2,1], nums2 = [2,2]
        //输出：[2,2]

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new ArrayIntersect().intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index = 0, index1 = 0, index2 = 0;
        int[] resArr = new int[nums1.length + nums2.length];
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                resArr[index++] = nums1[index1++];
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
