package com.leetcode.demo.aug_20;

public class MaxArea {

    public static void main(String[] args) {
        //输入：[1,8,6,2,5,4,8,3,7]
        //输出：49
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxArea().maxArea2(height));
    }

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(max, Math.min(height[j], height[i]) * (i - j));
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            int capacity = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, capacity);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }
}
