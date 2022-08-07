package com.leetcode.demo.easy.dec.dec_26;

public class FindKNum {

    public static void main(String[] args) {

        //输入: nums = [-1,0,3,5,9,12], target = 9
        //输出: 4

        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(new FindKNum().search(nums, 9));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
