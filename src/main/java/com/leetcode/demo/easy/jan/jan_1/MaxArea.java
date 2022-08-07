package com.leetcode.demo.easy.jan.jan_1;

public class MaxArea {

    public static void main(String[] args) {
        // 输入：[1,8,6,2,5,4,8,3,7]
        //输出：49
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxArea().maxArea(height));
    }

    // O(n*n)
    public int maxArea2(int[] height) {
        int max = 0;
        int len = height.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int val = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, val);
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int sum = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, sum);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
