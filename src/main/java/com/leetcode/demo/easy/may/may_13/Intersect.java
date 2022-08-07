package com.leetcode.demo.easy.may.may_13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Intersect {

    public static void main(String[] args) {
        // 输入：nums1 = [1,2,2,1], nums2 = [2,2]
        //输出：[2,2]

        // 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        //输出：[4,9]

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(new Intersect().intersect2(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length];
        int index = 0;

        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                res[index++] = nums1[index1];
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else index2++;
        }
        return Arrays.copyOf(res, index);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        int index = 0;
        for (int num1 : nums1) {
            map.put(num1, map.getOrDefault(num1, 0) + 1);
        }
        for (int num1 : nums2) {
            if (map.containsKey(num1)) {
                int freq = map.get(num1);
                freq--;
                if (freq >= 0) {
                    res[index++] = num1;
                    map.put(num1, freq);
                }
            }
        }
        return Arrays.copyOf(res, index);
    }
}
