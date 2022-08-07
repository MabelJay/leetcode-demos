package com.leetcode.demo.easy.apr.apr_28;

import java.util.Arrays;

public class WiggleSort {

    public static void main(String[] args) {
        // 输入：nums = [1,5,1,1,6,4]
        //输出：[1,6,1,5,1,4]
        //解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受
        int[] nums = {1, 5, 1, 1, 6, 4};
//        new WiggleSort().wiggleSort(nums);

        //输入：nums = [1,3,2,2,3,1]
        //输出：[2,3,1,3,1,2]
        int[] nums2 = {1, 3, 2, 2, 3, 1};
        new WiggleSort().wiggleSort2(nums);
    }

    public void wiggleSort(int[] nums) {
        int[] newArr = nums.clone();
        Arrays.sort(newArr);

        int len = newArr.length;
        int left = (len - 1) / 2;
        int right = len - 1;
        for (int i = 0; i < len - 1; i += 2) {
            nums[i] = newArr[left--];
            nums[i + 1] = newArr[right--];
        }
        if (len % 2 != 0) {
            nums[len - 1] = newArr[left];
        }
//        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort2(int[] nums) {

        int[] buckets = new int[5001];
        for (int num : nums) {
            buckets[num]++;
        }
        int len = nums.length;
        int j = 5000;
        for (int i = 1; i < len; i += 2) {
            while (buckets[j] == 0) {
                j--;
            }
            nums[i] = j;
            buckets[j]--;
        }
        for (int i = 0; i < len; i += 2) {
            while (buckets[j] == 0) {
                j--;
            }
            nums[i] = j;
            buckets[j]--;
        }
        System.out.println(Arrays.toString(nums));
    }
}
