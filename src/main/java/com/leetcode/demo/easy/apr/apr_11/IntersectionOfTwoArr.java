package com.leetcode.demo.easy.apr.apr_11;

import java.util.Arrays;

public class IntersectionOfTwoArr {

    public static void main(String[] args) {
        // 输入：nums1 = [1,2,2,1], nums2 = [2,2]
        //输出：[2]

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        // nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new IntersectionOfTwoArr().intersection(nums3, nums4)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] res = new int[nums1.length];
        int index1 = 0, index2 = 0;
        int index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                if (index == 0 || nums1[index1] != res[index - 1]) {
                    res[index++] = nums1[index1];
                }
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else index2++;
        }
        return Arrays.copyOf(res, index);
    }

    // if (nums1 == null || nums2 == null) return null;
    //        Arrays.sort(nums1);
    //        Arrays.sort(nums2);
    //
    //        int len1 = nums1.length, len2 = nums2.length;
    //        int index = 0, index1 = 0, index2 = 0;
    //        int[] resArr = new int[len1 + len2];
    //
    //        while (index1 < len1 && index2 < len2) {
    //            if (nums1[index1] == nums2[index2]) {
    //                if (index == 0 || nums1[index1] != resArr[index - 1]) {
    //                    resArr[index++] = nums1[index1];
    //                }
    //                index1++;
    //                index2++;
    //            } else if (nums1[index1] < nums2[index2]) {
    //                index1++;
    //            } else {
    //                index2++;
    //            }
    //        }
    //        return Arrays.copyOfRange(resArr, 0, index);
}
