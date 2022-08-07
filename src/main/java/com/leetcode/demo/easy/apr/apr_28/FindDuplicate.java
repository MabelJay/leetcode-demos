package com.leetcode.demo.easy.apr.apr_28;

public class FindDuplicate {

    public static void main(String[] args) {
        // 输入：nums = [1,3,4,2,2]
        //输出：2

        // 输入：nums = [3,1,3,4,2]
        //输出：3

        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(new FindDuplicate().findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
