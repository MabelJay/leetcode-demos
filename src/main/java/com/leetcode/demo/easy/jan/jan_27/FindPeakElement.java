package com.leetcode.demo.easy.jan.jan_27;

public class FindPeakElement {

    public static void main(String[] args) {
        // 输入：nums = [1,2,3,1]
        //输出：2
        //解释：3 是峰值元素，你的函数应该返回其索引 2。
        int[] nums = {11};

        // 输入：nums = [1,2,1,3,5,6,4]
        //输出：1 或 5
        System.out.println(new FindPeakElement().findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid < 1 && mid >= nums.length + 1) {
                return mid;
            } else if (mid < 1) {
                if (nums[mid] > nums[mid + 1]) return mid;
                else low = mid + 1;
            } else if (mid >= nums.length - 1) {
                if (nums[mid] > nums[mid - 1]) return mid;
                else high = mid - 1;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else {
                if (nums[mid] > nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
