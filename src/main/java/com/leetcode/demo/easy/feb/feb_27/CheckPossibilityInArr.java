package com.leetcode.demo.easy.feb.feb_27;

public class CheckPossibilityInArr {

    public static void main(String[] args) {
        // 输入: nums = [4,2,1]
        //输出: false

        // [3,4,2,3]
        // false
        int[] nums = {4,2,3};
        System.out.println(new CheckPossibilityInArr().checkPossibility2(nums));
    }

    public boolean checkPossibility(int[] nums) {
        int count = 0;

        int step = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
            }
            if (i > 1 && nums[i - 2] > nums[i]) {
                step++;
            }
            if (i < nums.length - 1 && nums[i + 1] < nums[i - 1] && step > 0) return false;

            if (count > 1) return false;
        }
        return true;
    }

    public boolean checkPossibility2(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
