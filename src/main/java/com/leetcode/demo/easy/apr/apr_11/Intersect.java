package com.leetcode.demo.easy.apr.apr_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Intersect {
    public static void main(String[] args) {
        // 输入：nums1 = [1,2,2,1], nums2 = [2,2]
        //输出：[2,2]

        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};

        // 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        //输出：[4,9]
        System.out.println(Arrays.toString(new Intersect().intersect(num1, num2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[len1];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] == nums2[index2]) {
                res[index++] = nums1[index1];
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) index1++;
            else index2++;
        }
        return Arrays.copyOf(res, index);
    }
    // if (nums1 == null || nums2 == null) return null;
    //
    //        Arrays.sort(nums1);
    //        Arrays.sort(nums2);
    //
    //        int index = 0, index1 = 0, index2 = 0;
    //        int[] resArr = new int[nums1.length + nums2.length];
    //        while (index1 < nums1.length && index2 < nums2.length) {
    //            if (nums1[index1] == nums2[index2]) {
    //                resArr[index++] = nums1[index1++];
    //                index2++;
    //            } else if (nums1[index1] < nums2[index2]) {
    //                index1++;
    //            } else {
    //                index2++;
    //            }
    //        }
    //        return Arrays.copyOfRange(resArr, 0, index);
}
