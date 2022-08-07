package com.leetcode.demo.easy;

import java.util.Arrays;

public class MedianSortedArrays_bak {
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {1, 5, 7, 9};
        int[] arr3 = {3, 4};
        int[] arr6 = {3, 4, 6, 8, 9, 10};
        int[] arr7 = {2, 7};

        int[] arr4 = {0, 0};
        int[] arr5 = {0, 0};

        MedianSortedArrays_bak sortedArrays = new MedianSortedArrays_bak();
//        System.out.println(sortedArrays.findSingleSortedArrMedia(arr4));
//        System.out.println(sortedArrays.findSingleSortedArrMedia(arr5));

//        System.out.println(sortedArrays.findMedianSortedArrays(arr1, arr7));
//        System.out.println(sortedArrays.findMedianSortedArrays(arr1, arr2));
        System.out.println(sortedArrays.findMedianSortedArrays3(arr4, arr5));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double media1 = findSingleSortedArrMedia(nums1);
        double media2 = findSingleSortedArrMedia(nums2);

        System.out.println("media1 is: " + media1 + "  media2 is: " + media2);
        if (media1 <= 0 || media2 <= 0) {
            return media1 <= 0 ? media2 : media1;
        }
        return (media1 + media2) / 2;
    }

    public double findSingleSortedArrMedia(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];
        int len = arr.length;
        int centerLeft = (len - 1) / 2;
        double res;
        if (len % 2 == 0) {
            int centerRight = centerLeft + 1;
            return (double) (arr[centerLeft] + arr[centerRight]) / 2;
        }
        return (double) arr[centerLeft] / 2;
    }

    // O(m+n)
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1 == null) return findSingleSortedArrMedia(nums2);
        if (nums2 == null) return findSingleSortedArrMedia(nums1);
        int i = 0, j = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int tmpPos = 0;
        int[] tmpArr = new int[len1 + len2];
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                tmpArr[tmpPos++] = nums1[i++];
            } else {
                tmpArr[tmpPos++] = nums2[j++];
            }
        }

        while (i < len1) {
            tmpArr[tmpPos++] = nums1[i++];
        }

        while (j < len2) {
            tmpArr[tmpPos++] = nums2[j++];
        }
        System.out.println(Arrays.toString(tmpArr));
        return findSingleSortedArrMedia(tmpArr);
    }

    // O(logN) O(log(m+n))
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int centerLeft = (len - 1) / 2;
        int centerRight = -1;
        boolean numFlag = false;
        boolean flag = true;
        if (len % 2 == 0) {
            numFlag = true;
            centerRight = centerLeft + 1;
        }

        int i = 0;
        int j = 0;
        int numRes = 0;
        int numResRight = 0;
        while (i < len1 && j < len2 && flag) {
            while (i < len1 && j < len2 && nums1[i] <= nums2[j] && flag) {
                if ((i + j) == centerLeft) {
                    numRes = nums1[i];
                }
                if (numRes != 0 && !numFlag) {
                    flag = false;
                }
                if ((i + j) == centerRight) {
                    numResRight = nums1[i];
                    flag = false;
                }
                i++;
            }

            while (i < len1 && j < len2 && nums2[j] <= nums1[i] && flag) {
                if ((i + j) == centerLeft) {
                    numRes = nums2[j];
                }
                if (numRes != 0 && !numFlag) {
                    flag = false;
                }
                if ((i + j) == centerRight) {
                    numResRight = nums2[j];
                    flag = false;
                }
                j++;
            }
        }
        while (i < len1 && (numRes == 0 || numFlag)) {
            if ((i + j) == centerLeft) {
                numRes = nums1[i];
            }
            if (numRes != 0 && !numFlag) {
                break;
            }
            if ((i + j) == centerRight) {
                numResRight = nums1[i];
                break;
            }
            i++;
        }

        while (j < len2 && (numRes == 0 || numFlag)) {
            if ((i + j) == centerLeft) {
                numRes = nums2[j];
            }
            if (numRes != 0 && !numFlag) {
                break;
            }
            if ((i + j) == centerRight) {
                numResRight = nums2[j];
                break;
            }
        }

        if (numFlag) {
            return (double) (numRes + numResRight) / 2;
        } else return (double) numRes;
    }
}
