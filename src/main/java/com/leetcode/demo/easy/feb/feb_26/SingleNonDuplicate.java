package com.leetcode.demo.easy.feb.feb_26;

public class SingleNonDuplicate {

    public static void main(String[] args) {

        // 输入: nums = [1,1,2,3,3,4,4,8,8]
        //输出: 2

        // 输入: nums =  [3,3,7,7,10,11,11]
        //输出: 10

        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(new SingleNonDuplicate().singleNonDuplicate(nums));
    }

    // O(logN) O(1)
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (high + low) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];
            int len = mid - low;
            if (len % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) {
                    high = mid - 2;
                } else low = mid + 2;
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low];
    }
}
