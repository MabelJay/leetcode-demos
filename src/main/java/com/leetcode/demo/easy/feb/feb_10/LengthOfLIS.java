package com.leetcode.demo.easy.feb.feb_10;

import java.util.Arrays;

public class LengthOfLIS {

    public static void main(String[] args) {
        // 输入：nums = [10,9,2,5,3,7,101,18]
        //输出：4
        //解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

        // [4,10,4,3,8,9]
        // 3

        // [0,1,0,3,2,3]
        // 4
        int[] nums = {5, 7, -24, 12};
        // [5,7,-24,12,13,2,3,12,5,6,35]
        // 6
        System.out.println(new LengthOfLIS().lengthOfLIS3(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(dp[i], maxAns);
        }
        return maxAns;
    }

    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;

        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
            System.out.println(Arrays.toString(d));
        }
        return len;
    }

    public int lengthOfLIS3(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}
