package com.leetcode.demo.easy.apr.apr_13;

public class MaxArea {
    public static void main(String[] args) {
        // 输入：[1,8,6,2,5,4,8,3,7]
        //输出：49

        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] arr2 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        // [1,8,6,2,5,4,8,3,7]
        System.out.println(new MaxArea().maxArea(arr));
        System.out.println(new MaxArea().maxArea(arr2));
        // 输入：height = [1,1]
        //输出：1
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int max = 0;
        int lenX;
        int lenY;
        while (left < right) {
            lenX = right - left;
            if (height[left] < height[right]) {
                lenY = height[left];
                left++;
            } else {
                lenY = height[right];
                right--;
            }
            max = Math.max(max, lenX * lenY);
        }
        return max;
    }

    //  int left = 0, right = height.length - 1;
    //        int max = 0;
    //        while (left < right) {
    //            int sum = Math.min(height[left], height[right]) * (right - left);
    //            max = Math.max(max, sum);
    //            if (height[left] < height[right]) {
    //                left++;
    //            } else {
    //                right--;
    //            }
    //        }
    //        return max;
}
