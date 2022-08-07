package com.leetcode.demo.easy.feb.feb_26;

public class FindUnsortedSubarray {

    public static void main(String[] args) {
        // 输入：nums = [2,6,4,8,10,9,15]
        //输出：5
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int[] nums2 = {2, 1};
        int[] nums3 = {1, 3, 2, 2, 2};

        // [1,2,4,5,3]
        // 4
        int[] nums4 = {1, 3, 5, 4, 2};
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray2(nums));
    }

    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int start = -1, end = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i + 1;
                }
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i + 1]);
            }
        }
        System.out.println("start=" + start + " end=" + end);
        System.out.println("max=" + max + " min=" + min);
        if (start == -1) return 0;
        if (end == 0) {
            end = start + 1;
        }
        int left = start - 1, right = end + 1;
        while (left >= 0 && nums[left] > min) {
            left--;
        }

        while (right < len && nums[right] < max) {
            right++;
        }
        return right - left - 1;
    }
}
