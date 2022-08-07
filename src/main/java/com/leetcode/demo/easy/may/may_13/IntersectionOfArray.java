package com.leetcode.demo.easy.may.may_13;

import java.util.*;

public class IntersectionOfArray {

    public static void main(String[] args) {
        // 输入：nums1 = [1,2,2,1], nums2 = [2,2]
        //输出：[2]

        // 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        //输出：[9,4]
        //解释：[4,9] 也是可通过的

        int[] nums1 = {4, 7, 9, 7, 6, 7};
        int[] nums2 = {5, 0, 0, 6, 1, 6, 2, 2, 4};

        // [4,7,9,7,6,7]
        //[5,0,0,6,1,6,2,2,4]
        System.out.println(Arrays.toString(new IntersectionOfArray().intersection3(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int[] res = new int[nums1.length];
        int index = 0;
        for (int num1 : nums1) {
            set.add(num1);
        }

        for (int num2 : nums2) {
            if (set.contains(num2)) {
                set2.add(num2);
            }
        }
        for (Integer num : set2) {
            res[index++] = num;
        }
        return Arrays.copyOf(res, index);
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                if (list.size() == 0 || nums1[index1] != list.get(list.size() - 1)) list.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int num : list) res[index++] = num;
        return res;
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        int index = 0;

        for (int num1 : nums1) {
            map.put(num1, 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                map.put(num, 2);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) res[index++] = entry.getKey();
        }
        return Arrays.copyOf(res, index);
    }
}
