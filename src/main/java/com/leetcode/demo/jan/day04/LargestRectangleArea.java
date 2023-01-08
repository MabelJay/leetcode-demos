package com.leetcode.demo.jan.day04;

import java.util.Arrays;
import java.util.LinkedList;

public class LargestRectangleArea {

    public static void main(String[] args) {
        // 输入：heights = [2,1,5,6,2,3]
        //输出：10

        // 输入： heights = [2,4]
        //输出： 4
        int[] heights = {2, 4};
        System.out.println(new LargestRectangleArea().largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0;
        while (index < len) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[index]) {
                int tmpIndex = stack.pop();
                left[tmpIndex] = stack.isEmpty() ? -1 : stack.peek();
                right[tmpIndex] = index;
            }
            stack.push(index);
            index++;
        }

        while (!stack.isEmpty()) {
            int tmpIndex = stack.pop();
            left[tmpIndex] = stack.isEmpty() ? -1 : stack.peek();
            right[tmpIndex] = len;
        }
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * heights[i]);
        }
        return maxArea;
    }
}
