package com.leetcode.demo.easy.apr.apr_19;

import java.util.Arrays;

public class MaxWidthRamp {

    public static void main(String[] args) {
        // 输入：[6,0,8,2,1,5]
        //输出：4
        //解释：
        //最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.

        // 输入：[9,8,1,0,1,9,4,0,4,1]
        //输出：7
        //解释：
        //最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.

        int[] nums = {6, 0, 8, 2, 1, 5};
        System.out.println(new MaxWidthRamp().maxWidthRamp(nums));
    }

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; ++i)
            arr[i] = i;

        Arrays.sort(arr, (i, j) -> ((Integer) nums[i]).compareTo(nums[j]));

        int ans = 0;
        int m = n;
        for (int i : arr) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }
}
