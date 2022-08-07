package com.leetcode.demo.easy.dec.dec_31;

import com.leetcode.demo.easy.dec.dec_30.SortArrayByParity;

import java.util.Arrays;

public class SortArrayByParityII {

    public static void main(String[] args) {
        // 输入：[4,2,5,7]
        //输出：[4,5,2,7]
        //解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。

        //[3,0,4,0,2,1,3,1,3,4]
        // [2,3,1,1,4,0,0,4,3,3]
        int[] nums = {2,3,1,1,4,0,0,4,3,3};
        System.out.println(Arrays.toString(new SortArrayByParityII().sortArrayByParityII(nums)));
    }

    public int[] sortArrayByParityII(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (left % 2 == 0) {
                if (nums[left] % 2 == 0) {
                    left++;
                } else {
                    while (left < right && nums[right] % 2 != 0 && right % 2 != 0) {
                        right--;
                    }
                    if (left < right) {
                        swap(nums, left, right);
                        if (right % 2 != 0) {
                            right--;
                        }
                        left++;
                    }
                }
            } else {
                if (nums[left] % 2 != 0) {
                    left++;
                } else {
                    while (left < right && nums[right] % 2 == 0 && right % 2 == 0) {
                        right--;
                    }
                    if (left < right) {
                        swap(nums, left, right);
                        if (right % 2 == 0) {
                            right--;
                        }
                        left++;
                    }
                }
            }
        }
        return nums;
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
