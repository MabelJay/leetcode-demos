package com.leetcode.demo.oct.day26;

import java.util.Arrays;

public class Trap {

    public static void main(String[] args) {
        // 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        //输出：6

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Trap().trap(height));
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        maxLeft[0] = height[0];
        maxRight[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(maxRight));

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ans;
    }
}
