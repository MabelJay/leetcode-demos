package com.leetcode.demo.easy.mar.mar_10;

public class SingleNonDuplicate {

    public static void main(String[] args) {
        // 输入: nums = [1,1,2,3,3,4,4,8,8]
        //输出: 2
        // {1, 1, 2, 3, 3, 4, 4, 8, 8}

        // 输入: nums =  [3,3,7,7,10,11,11]
        //输出: 10

        int[] nums = {1, 2, 2, 3, 3};
        System.out.println(new SingleNonDuplicate().singleNonDuplicate(nums));
    }

    public int singleNonDuplicate2(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum ^= nums[i];
        }
        return sum;
    }

    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int halfLen = mid - low;

            if (halfLen % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) high = mid - 2;
                else if (nums[mid] == nums[mid + 1]) low = mid + 2;
                else return nums[mid];
            } else {
                if (nums[mid] == nums[mid - 1]) low = mid + 1;
                else if (nums[mid] == nums[mid + 1]) high = mid - 1;
                else return nums[mid];
            }
        }
        return nums[low];
    }
}
