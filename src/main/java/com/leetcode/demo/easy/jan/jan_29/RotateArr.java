package com.leetcode.demo.easy.jan.jan_29;

import java.util.Arrays;

public class RotateArr {

    public static void main(String[] args) {
        // 输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]

        // 输入：nums = [-1,-100,3,99], k = 2
        //输出：[3,99,-1,-100]

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new RotateArr().rotate4(nums, 3);
    }

    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        int len = nums.length;
        if (k == len) return;

        for (int i = 0; i < k; i++) {
            int temp = nums[len - 1];
            for (int j = len - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        int len = nums.length;
        if (len == k) return;
        int[] tmpArr = new int[k];
        int index = 0;
        k = k % len;
        for (int i = len - 1; i >= len - k; i--) {
            tmpArr[index++] = nums[i];
        }

        System.out.println(Arrays.toString(tmpArr));

        for (int i = len - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        System.out.println(Arrays.toString(nums));
        for (int i = k - 1; i >= 0; i--) {
            nums[i] = tmpArr[k - i - 1];
        }

        System.out.println(Arrays.toString(nums));
    }

    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        int[] newArr = new int[len];
        for (int i = 0; i < len; i++) {
            newArr[(i + k) % len] = nums[i];
        }

        System.arraycopy(newArr, 0, nums, 0, len);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
