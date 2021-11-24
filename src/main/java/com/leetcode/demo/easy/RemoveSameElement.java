package com.leetcode.demo.easy;

import java.util.Arrays;

public class RemoveSameElement {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        System.out.println(new RemoveSameElement().remove(arr, 2));
        System.out.println(Arrays.toString(arr));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] != val) {
                nums[slow++] = nums[fast++];
            }
            fast++;
        }
        return slow;
    }

    public int remove(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
