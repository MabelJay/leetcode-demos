package com.leetcode.demo.easy.apr.apr_13;

public class MinSubArrayLen {

    public static void main(String[] args) {
        // 输入：target = 7, nums = [2,3,1,2,4,3]
        //输出：2
        //解释：子数组 [4,3] 是该条件下的长度最小的子数组。

        // 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
        //输出：0

        int[] nums = {1, 4, 4};
        System.out.println(new MinSubArrayLen().minSubArrayLen2(4, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        int sum = 0;
        int minCount = Integer.MAX_VALUE;
        while (left < len) {
            while (right < len && sum < target) {
                sum += nums[right];
                right++;
            }
            if (sum >= target) {
                minCount = Math.min(minCount, right - left);
            }
            sum -= nums[left];
            left++;
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        int sum = 0;
        int minCount = Integer.MAX_VALUE;
        while (right < len) {
            sum += nums[right];
            while (sum >= target) {
                minCount = Math.min(minCount, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    // int start = 0, end = 0;
    //        int len = nums.length;
    //        int sum = 0;
    //        int ans = Integer.MAX_VALUE;
    //        while (end < len) {
    //            sum += nums[end];
    //            while (sum >= target) {
    //                ans = Math.min(ans, end - start + 1);
    //                sum -= nums[start];
    //                start++;
    //            }
    //            end++;
    //        }
    //        return ans == Integer.MAX_VALUE ? 0 : ans;
}
